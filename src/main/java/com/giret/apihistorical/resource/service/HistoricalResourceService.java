package com.giret.apihistorical.resource.service;

import com.giret.apihistorical.resource.model.HistoricalResource;

import java.util.List;


public interface HistoricalResourceService {

    HistoricalResource saveHistorialRecurso(HistoricalResource historialRecurso);

    List<HistoricalResource> getAllHistoriales();

    List<HistoricalResource> getHistorialesByRecursoId(Long recursoId);
}
