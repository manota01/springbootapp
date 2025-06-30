package com.example.springbootapp.controller;

import com.example.springbootapp.model.Property;
import com.example.springbootapp.service.RealEstateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PropertyController.class)
class PropertyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RealEstateService realEstateService;

    @Test
    void getProperties_returnsList() throws Exception {
        List<Property> props = List.of(new Property("Home", "Street", "$10"));
        when(realEstateService.fetchProperties()).thenReturn(props);

        mockMvc.perform(get("/properties"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Home"))
                .andExpect(jsonPath("$[0].address").value("Street"))
                .andExpect(jsonPath("$[0].price").value("$10"));
    }
}
