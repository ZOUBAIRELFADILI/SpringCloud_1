package com.mundia.msfiliere.services;


import com.mundia.msfiliere.dto.FiliereDTO;
import com.mundia.msfiliere.dto.FiliereReq;
import com.mundia.msfiliere.entities.Filiere;

import java.util.List;

public interface FiliereService {
    Filiere getFiliereById(Long id);
    List<Filiere> getAllFilieres();
    Filiere addFiliere(FiliereReq filiereReq);
    Filiere updateFiliere(Long id,FiliereReq filiereReq);
    void deleteFiliere(Long id);
    //-------------filieres avec étudiants
    FiliereDTO getFiliereDTOById(Long id);

}
