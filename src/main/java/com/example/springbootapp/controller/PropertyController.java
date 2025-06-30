package com.example.springbootapp.controller;

import com.example.springbootapp.model.Property;
import com.example.springbootapp.service.RealEstateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class PropertyController {
    private final RealEstateService realEstateService;

    public PropertyController(RealEstateService realEstateService) {
        this.realEstateService = realEstateService;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<Property>> getProperties() throws IOException {
        List<Property> properties = realEstateService.fetchProperties();
        return ResponseEntity.ok(properties);
    }
}
