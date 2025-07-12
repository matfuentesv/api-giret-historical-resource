package com.giret.apihistorical.resource.controller;


import com.giret.apihistorical.resource.model.HistoricalResource;
import com.giret.apihistorical.resource.service.HistoricalResourceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HistoricalResourceController.class)
class HistoricalResourceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HistoricalResourceService historicalResourceService;

    @TestConfiguration
    static class TestConfig {
        @Bean
        public HistoricalResourceService historicalResourceService() {
            return Mockito.mock(HistoricalResourceService.class);
        }
    }

    private HistoricalResource historicalResource;

    @BeforeEach
    void setUp() {
        historicalResource = new HistoricalResource();
        historicalResource.setIdHistorial(1L);
        historicalResource.setRecursoId(100L);
        historicalResource.setFechaCambioEstado("2024-07-15 12:00:00");
        historicalResource.setAccion("CREACION");
        historicalResource.setDescripcion("Recurso creado");
    }

    @Test
    void shouldCreateHistoricalResource() throws Exception {
        when(historicalResourceService.saveHistorialRecurso(any(HistoricalResource.class)))
                .thenReturn(historicalResource);

        String json = """
            {
              "recursoId": 100,
              "fechaCambioEstado": "2024-07-15 12:00:00",
              "accion": "CREACION",
              "descripcion": "Recurso creado"
            }
        """;

        mockMvc.perform(post("/api/saveHistoricalResource")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.recursoId").value(100))
                .andExpect(jsonPath("$.accion").value("CREACION"))
                .andExpect(jsonPath("$.descripcion").value("Recurso creado"));
    }

    @Test
    void shouldGetAllHistoricalResource() throws Exception {
        when(historicalResourceService.getAllHistoriales()).thenReturn(List.of(historicalResource));

        mockMvc.perform(get("/api/findAllHistoricalResource"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].recursoId").value(100))
                .andExpect(jsonPath("$[0].accion").value("CREACION"));
    }

    @Test
    void shouldFindHistoricalResourceByResourceId() throws Exception {
        when(historicalResourceService.getHistorialesByRecursoId(100L))
                .thenReturn(List.of(historicalResource));

        mockMvc.perform(get("/api/findHistoricalResource/100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].recursoId").value(100))
                .andExpect(jsonPath("$[0].accion").value("CREACION"));
    }
}
