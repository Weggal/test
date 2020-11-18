package com.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Kunde {

    private UUID kid;
    private String nachname;
    private String vorname;
    private List<Rechnung> rechnungen;

    public Kunde(@JsonProperty("kid") UUID id,
                @JsonProperty("vorname") String vorname,
                @JsonProperty("nachname") String nachname){
        this.kid = id;
        this.vorname=vorname;
        this.nachname=nachname;
        this.rechnungen=new ArrayList<Rechnung>();
    }

    public UUID getId(){
        return kid;
    }

    public String getVorname(){
        return vorname;
    }

    public String getNachname(){
        return nachname;
    }

    public List<Rechnung> getRechnungen(){
        return rechnungen;
    }
}
