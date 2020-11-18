package com.example.model;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rechnung {
    private UUID rid;
    private String rechnugsnummer;
    private LocalDate rechnungsdatum;
    private float Rechnungsbetrag;
    private Kunde kunde;

    public Rechnung(@JsonProperty("rid") UUID id,
                @JsonProperty("rechnugsnummer") String rechnugsnummer,
                @JsonProperty("Rechnungsbetrag") float Rechnungsbetrag,
                @JsonProperty("kunde") Kunde kunde){
        this.rid = id;
        this.rechnugsnummer=rechnugsnummer;
        this.rechnungsdatum=java.time.LocalDate.now();
        this.Rechnungsbetrag=Rechnungsbetrag;
        this.kunde=kunde;
    }
}
