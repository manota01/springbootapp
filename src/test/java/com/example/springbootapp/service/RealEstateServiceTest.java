package com.example.springbootapp.service;

import com.example.springbootapp.model.Property;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RealEstateServiceTest {
    private final RealEstateService service = new RealEstateService();

    @Test
    void parseProperties_parsesHtml() {
        String html = "<article>" +
                "<a>Nice Home</a>" +
                "<span class='address'>1 Test St</span>" +
                "<span class='price'>$100</span>" +
                "</article>";
        Document doc = Jsoup.parse(html);
        List<Property> properties = service.parseProperties(doc);
        assertEquals(1, properties.size());
        Property prop = properties.get(0);
        assertEquals("Nice Home", prop.getTitle());
        assertEquals("1 Test St", prop.getAddress());
        assertEquals("$100", prop.getPrice());
    }
}
