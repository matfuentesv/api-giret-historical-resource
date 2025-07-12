package com.giret.apihistorical.resource.service;



import com.giret.apihistorical.resource.model.HistoricalResource;
import com.giret.apihistorical.resource.repository.HistoricalResourceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class HistoricalResourceServiceImplTest {

    @InjectMocks
    private HistoricalResourceServiceImpl historicalResourceService;

    @Mock
    private HistoricalResourceRepository historicalResourceRepository;

    private HistoricalResource historicalResource;

    @BeforeEach
    void setUp() {
        historicalResource = new HistoricalResource();
        historicalResource.setRecursoId(100L);
        historicalResource.setFechaCambioEstado("2024-07-15 12:00:00");
        historicalResource.setAccion("CREACION");
        historicalResource.setDescripcion("Recurso creado");
    }

    @Test
    void shouldSaveHistoricalResource() {
        when(historicalResourceRepository.save(any(HistoricalResource.class)))
                .thenReturn(historicalResource);

        HistoricalResource saved = historicalResourceService.saveHistorialRecurso(historicalResource);

        assertNotNull(saved);
        assertEquals(100L, saved.getRecursoId());
        verify(historicalResourceRepository, times(1)).save(historicalResource);
    }

    @Test
    void shouldGetAllHistoricalResource() {
        when(historicalResourceRepository.findAll()).thenReturn(List.of(historicalResource));

        List<HistoricalResource> result = historicalResourceService.getAllHistoriales();

        assertEquals(1, result.size());
        assertEquals(100L, result.get(0).getRecursoId());
    }

    @Test
    void shouldReturnEmptyWhenNoHistoricalResource() {
        when(historicalResourceRepository.findAll()).thenReturn(List.of());

        List<HistoricalResource> result = historicalResourceService.getAllHistoriales();

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldFindHistoricalResourceByResourceId() {
        when(historicalResourceRepository.findAll()).thenReturn(List.of(historicalResource));

        List<HistoricalResource> result = historicalResourceService.getHistorialesByRecursoId(100L);

        assertEquals(1, result.size());
        assertEquals(100L, result.get(0).getRecursoId());
    }

    @Test
    void shouldReturnEmptyWhenNoHistoricalResourceFoundByResourceId() {
        when(historicalResourceRepository.findAll()).thenReturn(List.of());

        List<HistoricalResource> result = historicalResourceService.getHistorialesByRecursoId(999L);

        assertTrue(result.isEmpty());
    }
}
