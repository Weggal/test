package com.example.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.model.Rechnung;
import com.example.service.RechnungenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/rechnung")
@RestController
public class RechnungenController {
    
    private final RechnungenService rechnungenService;

    @Autowired
    public RechnungenController(RechnungenService rechnungenService){
        this.rechnungenService = rechnungenService;
    }    

    @PostMapping(path = "{id}")
    public void addRechnung(@RequestBody Rechnung rechnung, @PathVariable("id") UUID id){
        rechnungenService.addRechnung(rechnung, id);
    }

    @GetMapping
    public List<Rechnung> getAllRechnungen() {
        return rechnungenService.getAllRechnungen();
    }

    @GetMapping(path = "{id}")
    public Optional<Rechnung> getRechnungById(@PathVariable("id") UUID id) {
        return rechnungenService.getRechnungById(id);
    }
}
