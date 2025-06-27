package com.giret.apigiretresources.controller;

import com.giret.apigiretresources.model.HistoricalResource;
import com.giret.apigiretresources.model.Recurso;
import com.giret.apigiretresources.service.HistoricalResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HistoricalResourceController {

    @Autowired
    HistoricalResourceService historicalResourceService;


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
