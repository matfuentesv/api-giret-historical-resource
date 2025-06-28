package com.giret.apihistorical.resource.service;

import com.giret.apihistorical.resource.model.HistoricalResource;
import com.giret.apihistorical.resource.repository.HistoricalResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricalResourceServiceImpl implements HistoricalResourceService {

    @Autowired
    HistoricalResourceRepository historicalResourceRepository;


    @Override
    public HistoricalResource saveHistorialRecurso(HistoricalResource historialRecurso) {
        return historicalResourceRepository.save(historialRecurso);
    }

    @Override
    public List<HistoricalResource> getAllHistoriales() {
        return historicalResourceRepository.findAll();
    }

    @Override
    public List<HistoricalResource> getHistorialesByRecursoId(Long recursoId) {
        return historicalResourceRepository.findAll().stream()
                .filter(h -> h.getRecursoId().equals(recursoId))
                .toList();
    }
}
