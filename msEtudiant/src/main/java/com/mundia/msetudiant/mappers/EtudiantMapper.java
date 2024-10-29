package com.mundia.msetudiant.mappers;

import com.mundia.msetudiant.dto.EtudiantReq;
import com.mundia.msetudiant.entities.Etudiant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EtudiantMapper {

    public Etudiant fromEtudiantReq(EtudiantReq etudiantReq){
        Etudiant etudiant = new Etudiant();
        BeanUtils.copyProperties(etudiantReq, etudiant);
        return etudiant;
    }
}
