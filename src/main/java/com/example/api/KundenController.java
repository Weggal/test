package com.example.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.model.Kunde;
import com.example.service.KundenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/v1/kunde")
@RestController
public class KundenController {

    
    private final KundenService kundenService;

    @Autowired
    public KundenController(KundenService kundenService){
        this.kundenService = kundenService;
    }    

    @PostMapping
    public void addKunde(@RequestBody Kunde kunde){
        kundenService.addKunde(kunde);
    }

    @GetMapping
    public List<Kunde> getAllKunden() {
        return kundenService.getAllKunden();
    }

    @GetMapping(path = "{id}")
    public Optional<Kunde> getKundeById(@PathVariable("id") UUID id) {
        return kundenService.getKundeById(id);
    }

    @DeleteMapping(path = "{id}")
    public int deleteKunde(@PathVariable("id") UUID id){
        return kundenService.deleteKunde(id);
    }

    @PutMapping(path = "{id}")
    public int updateKunde(@PathVariable("id") UUID id,@RequestBody Kunde kunde){
        return kundenService.updateKunde(id,  kunde);
    }
}
