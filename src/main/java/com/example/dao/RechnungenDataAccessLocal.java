package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.model.Kunde;
import com.example.model.Rechnung;

import org.springframework.stereotype.Repository;

@Repository("localRechnungDao")
public class RechnungenDataAccessLocal implements RechnungenDao {

    private static List<Rechnung> DB = new ArrayList<>();

    @Override
    public int insertRechnung(UUID id, Rechnung rechnung, Kunde kunde) {
        Rechnung r= new Rechnung(id, rechnung.getRechnugsnummer(),rechnung.getRechnungsbetrag(), kunde);
        r.getKunde().addRechnung(r);
        DB.add(r);
        return 1;
    }

    @Override
    public Optional<Rechnung> selectRechnungById(UUID id) {
        return DB.stream().filter(rechnung -> rechnung.getId().equals(id)).findFirst();
    }

    @Override
    public List<Rechnung> selectAllRechnungen() {
        return DB;
    }
    
}