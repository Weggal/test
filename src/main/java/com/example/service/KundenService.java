package com.example.service;

import java.util.Optional;
import java.util.UUID;

import com.example.dao.KundenDao;
import com.example.model.Kunde;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class KundenService {
    public final KundenDao kundenDao;

    @Autowired
    public KundenService(@Qualifier("localKundenDao") KundenDao kunenDao){
        this.kundenDao=kunenDao;
    }

    public int addKunde(Kunde kunde){
        return kundenDao.insertKunde(kunde);
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
