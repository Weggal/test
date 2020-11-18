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
    public final KundenService kundenService;

    @Autowired
    public RechnungenService(@Qualifier("localRechnungDao") RechnungenDao rechnungenDao,KundenService kundenService){
        this.rechnungenDao=rechnungenDao;
        this.kundenService=kundenService;
    }

    public int addRechnung(Rechnung rechnung, UUID kid){
        kundenService.getKundeById(kid).get().addRechnung(rechnung);
        return rechnungenDao.insertRechnung(rechnung, kundenService.getKundeById(kid).get());
    }

    public List<Rechnung> getAllRechnungen() {
        return rechnungenDao.selectAllRechnungen();
    }

    public Optional<Rechnung> getRechnungById(UUID id){
        return rechnungenDao.selectRechnungById(id);
    }
 

}
