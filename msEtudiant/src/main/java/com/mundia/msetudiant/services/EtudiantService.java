package com.mundia.msetudiant.services;

import com.mundia.msetudiant.dto.EtudiantDTO;
import com.mundia.msetudiant.dto.EtudiantReq;
import com.mundia.msetudiant.entities.Etudiant;

import java.util.List;

public interface EtudiantService {
    Etudiant getEtudiant(Long id);
    List<Etudiant> getAllEtudiants();
    List<Etudiant> getEtudiantsByFilId(Long id);
    List<Etudiant> getEtudiantsByName(String nom);
    Etudiant addEtudiant(EtudiantReq etudiant);
    Etudiant updateEtudiant(EtudiantReq etudiant);
    void deleteEtudiant(Long id);
    //----------------------------------
    EtudiantDTO getEtudiantAvecFiliere(Long id);
}
