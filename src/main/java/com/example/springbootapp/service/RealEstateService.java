package com.example.springbootapp.service;

import com.example.springbootapp.model.Property;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RealEstateService {
    private static final String SEARCH_URL = "https://www.realestate.com.au/rent/in-2147/list-1";

    public List<Property> fetchProperties() throws IOException {
        Document doc = Jsoup.connect(SEARCH_URL).get();
        return parseProperties(doc);
    }

    /**
     * Parse the property listings from the fetched HTML document. This method is
     * separated out to make unit testing easier.
     */
    public List<Property> parseProperties(Document doc) {
        List<Property> properties = new ArrayList<>();
        if (doc == null) {
            return properties;
        }
        for (Element card : doc.select("article")) {
            Element titleEl = card.selectFirst("a");
            Element addressEl = card.selectFirst("span[class*=address]");
            Element priceEl = card.selectFirst("span[class*=price]");
            if (titleEl != null && addressEl != null && priceEl != null) {
                properties.add(new Property(titleEl.text(), addressEl.text(), priceEl.text()));
            }
        }
        return properties;
    }
}
