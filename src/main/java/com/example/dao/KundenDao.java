package com.example.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.model.Kunde;

public interface KundenDao {

    int insertKunde(UUID id, Kunde kunde );

    default int  insertKunde(Kunde kunde ){
        UUID id = UUID.randomUUID();
        return insertKunde(id, kunde);
    }

    List<Kunde> selectAllKunde();

    Optional<Kunde> selectKundeById(UUID id);

    int deleteKundeById(UUID id);

    int updateKundeById(UUID id, Kunde update);
}
