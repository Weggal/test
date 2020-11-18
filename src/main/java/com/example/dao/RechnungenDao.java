package com.example.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.model.Rechnung;

public interface RechnungenDao {

    int insertRechnung(UUID id, Rechnung rechnung);

    default int  insertRechnung(Rechnung rechnung){
        UUID id = UUID.randomUUID();
        return insertRechnung(id, rechnung);
    }

    List<Rechnung> selectAllKunde();

    Optional<Rechnung> selectRechnungById(UUID id);

    int deletRechnungById(UUID id);
}
    
