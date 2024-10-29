package com.mundia.msfiliere.services;

import com.mundia.msfiliere.dto.EtudiantDTO;
import com.mundia.msfiliere.dto.FiliereDTO;
import com.mundia.msfiliere.dto.FiliereReq;
import com.mundia.msfiliere.entities.Filiere;
import com.mundia.msfiliere.mappers.FilereMapper;
import com.mundia.msfiliere.repositories.FiliereRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FiliereServiceImpl implements FiliereService{
    final FiliereRepo filiereRepo;
    final FilereMapper filereMapper;
    final WebClient webClient;
    @Override
    public Filiere getFiliereById(Long id) {
        Optional<Filiere> optionalFiliere = filiereRepo.findById(id);
        if(optionalFiliere.isPresent()){
            return optionalFiliere.get();
        }else {
            throw new EntityNotFoundException("Filiere with id " + id + " not found");
        }
    }

    @Override
    public List<Filiere> getAllFilieres() {
        return filiereRepo.findAll();
    }

    @Override
    public Filiere addFiliere(FiliereReq filiereReq) {
        Filiere filiere = filereMapper.fromFiliereReq(filiereReq);
        filiereRepo.save(filiere);
        return filiere;
    }

    @Override
    public Filiere updateFiliere(Long id, FiliereReq filiereReq) {
        return null;
    }



    @Override
    public void deleteFiliere(Long id) {

    }

    @Override
    public FiliereDTO getFiliereDTOById(Long id) {
        Filiere filiere = getFiliereById(id);
        EtudiantDTO[] etudiantDTOS = webClient.get()
                .uri("http://localhost:8080/api/etudiant/etudiantbyidfiliere/"+id)
                .retrieve()
                .bodyToMono(EtudiantDTO[].class)
                .share()
                .block();
        //---------------------------------------------
        FiliereDTO filiereDTO = new FiliereDTO();
        BeanUtils.copyProperties(filiere, filiereDTO);
        filiereDTO.setEtudiants(Arrays.asList(etudiantDTOS));
        return filiereDTO;
    }
}
