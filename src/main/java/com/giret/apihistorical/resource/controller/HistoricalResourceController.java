package com.giret.apihistorical.resource.controller;

import com.giret.apihistorical.resource.model.HistoricalResource;
import com.giret.apihistorical.resource.service.HistoricalResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HistoricalResourceController {


    private final HistoricalResourceService historicalResourceService;

    public HistoricalResourceController(HistoricalResourceService historicalResourceService) {
        this.historicalResourceService = historicalResourceService;
    }

    @PostMapping("/saveHistoricalResource")
    public ResponseEntity<HistoricalResource> saveHistorial(@RequestBody HistoricalResource historialRecurso) {
        HistoricalResource saved = historicalResourceService.saveHistorialRecurso(historialRecurso);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/findAllHistoricalResource")
    public ResponseEntity<List<HistoricalResource>> getAllHistoriales() {
        return ResponseEntity.ok(historicalResourceService.getAllHistoriales());
    }

    @GetMapping("/findHistoricalResource/{recursoId}")
    public ResponseEntity<List<HistoricalResource>> getHistorialesByRecurso(@PathVariable Long recursoId) {
        return ResponseEntity.ok(historicalResourceService.getHistorialesByRecursoId(recursoId));
    }

}
