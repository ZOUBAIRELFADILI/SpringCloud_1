package com.mundia.msfiliere.mappers;

import com.mundia.msfiliere.dto.FiliereReq;
import com.mundia.msfiliere.entities.Filiere;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class FilereMapper {
    public Filiere fromFiliereReq(FiliereReq filiereReq) {
        Filiere filiere = new Filiere();
        BeanUtils.copyProperties(filiereReq, filiere);
        return filiere;
    }
}
