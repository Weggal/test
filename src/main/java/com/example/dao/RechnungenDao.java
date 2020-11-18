package com.example.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.model.Kunde;
import com.example.model.Rechnung;

public interface RechnungenDao {

    int insertRechnung(UUID id, Rechnung rechnung, Kunde kunde);

    default int  insertRechnung(Rechnung rechnung, Kunde kunde){
        UUID id = UUID.randomUUID();
        return insertRechnung(id, rechnung, kunde);
    }

    List<Rechnung> selectAllRechnungen();

    Optional<Rechnung> selectRechnungById(UUID id);
}
    
