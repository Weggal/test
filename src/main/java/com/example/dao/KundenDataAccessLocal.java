package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.model.Kunde;

import org.springframework.stereotype.Repository;

@Repository("localKundenDao")
public class KundenDataAccessLocal implements KundenDao {

    private static List<Kunde> DB = new ArrayList<>();

    @Override
    public int insertKunde(UUID id, Kunde kunde) {
        DB.add(new Kunde(id, kunde.getVorname(), kunde.getNachname()));
        return 1;
    }

    @Override
    public List<Kunde> selectAllKunde() {
        return DB;
    }

    @Override
    public Optional<Kunde> selectKundeById(UUID id) {
        return DB.stream().filter(kunde -> kunde.getId().equals(id)).findFirst();
    }

    @Override
    public int deletKundeById(UUID id) {
        Optional<Kunde> kundeMaybe = selectKundeById(id);
        if (kundeMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(kundeMaybe.get());
        return 1;
    }

    @Override
    public int updateKundeById(UUID id, Kunde update) {
        return selectKundeById(id).map(p -> {
            int indexOfKundeToUpdate = DB.indexOf(p);
            if (indexOfKundeToUpdate >= 0) {
                DB.set(indexOfKundeToUpdate, new Kunde(id, update.getVorname(), update.getNachname()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
    
}