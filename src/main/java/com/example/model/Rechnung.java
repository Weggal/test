package com.example.model;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rechnung {
    private UUID rid;
    private String rechnungsnummer;
    private LocalDate rechnunngsdatum;
    private float rechnungsbetrag;
    private Kunde kunde;

    public Rechnung(@JsonProperty("rid") UUID id,
                @JsonProperty("rechnungsnummer") String rechnungsnummer,
                @JsonProperty("rechnungsbetrag") float rechnungsbetrag,
                @JsonProperty("kunde")Kunde kunde){
        this.rid = id;
        this.rechnungsnummer=rechnungsnummer;
        this.rechnunngsdatum=java.time.LocalDate.now();
        this.rechnungsbetrag=rechnungsbetrag;
        this.kunde=kunde;
    }

    public UUID getId(){
        return rid;
    }

    public String getRechnugsnummer(){
        return rechnungsnummer;
    }

    public LocalDate getRechnungsdatum(){
        return rechnunngsdatum;
    }

    public float getRechnungsbetrag(){
        return rechnungsbetrag;
    }

    public Kunde getKunde(){
        return kunde;
    }
}
