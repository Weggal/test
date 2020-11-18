package com.example.model;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rechnung {
    private UUID rid;
    private String rechnugsnummer;
    private LocalDate rechnungsdatum;
    private float rechnungsbetrag;
    private Kunde kunde;

    public Rechnung(@JsonProperty("rid") UUID id,
                @JsonProperty("rechnugsnummer") String rechnugsnummer,
                @JsonProperty("Rechnungsbetrag") float rechnungsbetrag,
                @JsonProperty("kunde") Kunde kunde){
        this.rid = id;
        this.rechnugsnummer=rechnugsnummer;
        this.rechnungsdatum=java.time.LocalDate.now();
        this.rechnungsbetrag=rechnungsbetrag;
        this.kunde=kunde;
    }

    public UUID getId(){
        return rid;
    }

    public String getRechnugsnummer(){
        return rechnugsnummer;
    }

    public LocalDate getRechnungsdatum(){
        return rechnungsdatum;
    }

    public float getRechnungsbetrag(){
        return rechnungsbetrag;
    }

    public Kunde getKunde(){
        return kunde;
    }
}
