package com.giret.apigiretresources.service;

import com.giret.apigiretresources.model.HistoricalResource;
import com.giret.apigiretresources.model.Recurso;

import java.util.List;


public interface HistoricalResourceService {

    HistoricalResource saveHistorialRecurso(HistoricalResource historialRecurso);

    List<HistoricalResource> getAllHistoriales();

    List<HistoricalResource> getHistorialesByRecursoId(Long recursoId);
}
