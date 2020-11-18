package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.dao.RechnungenDao;
import com.example.model.Rechnung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RechnungenService {
    public final RechnungenDao rechnungenDao;

    @Autowired
    public KundenService(@Qualifier("localKundenDao") RechnungenDao rechnungenDao){
        this.rechnungenDao=rechnungenDao;
    }

    public int addKunde(Kunde kunde){
        return kundenDao.insertKunde(kunde);
    }

    public List<Kunde> getAllKunden() {
        return kundenDao.selectAllKunde();
    }

    public Optional<Kunde> getKundeById(UUID id){
        return kundenDao.selectKundeById(id);
    }

    public int deleteKunde(UUID id){
        return kundenDao.deleteKundeById(id);
    }

    public int updateKunde(UUID id,Kunde kunde){
        return kundenDao.updateKundeById(id, kunde);
    }    

}
