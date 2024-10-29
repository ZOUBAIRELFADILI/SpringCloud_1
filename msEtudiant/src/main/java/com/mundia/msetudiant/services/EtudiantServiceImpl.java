package com.mundia.msetudiant.services;

import com.mundia.msetudiant.dto.EtudiantDTO;
import com.mundia.msetudiant.dto.EtudiantReq;
import com.mundia.msetudiant.dto.FiliereDTO;
import com.mundia.msetudiant.entities.Etudiant;
import com.mundia.msetudiant.mappers.EtudiantMapper;
import com.mundia.msetudiant.repositories.EtudiantRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {
    final EtudiantRepo etudiantRepo;
    final EtudiantMapper etudiantMapper;
    final WebClient webClient;

    @Override
    public Etudiant getEtudiant(Long id) {
        Optional<Etudiant> optionalEtudiant=etudiantRepo.findById(id);
        if(optionalEtudiant.isPresent()){
            return optionalEtudiant.get();
        }else {
            throw new EntityNotFoundException("Etudiant n'existe pas!");
        }
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantRepo.findAll();
        return etudiants;
    }

    @Override
    public List<Etudiant> getEtudiantsByFilId(Long id) {
        return etudiantRepo.findAllByIdFiliere(id);
    }

    @Override
    public List<Etudiant> getEtudiantsByName(String nom) {
        List<Etudiant> etudiants = etudiantRepo.findAllByNom(nom);
        return etudiants;
    }

    @Override
    public Etudiant addEtudiant(EtudiantReq etudiant) {
        Etudiant etudiant1 = etudiantMapper.fromEtudiantReq(etudiant);
        etudiantRepo.save(etudiant1);
        return etudiant1;
    }

    @Override
    public Etudiant updateEtudiant(EtudiantReq etudiant) {
        return null;
    }

    @Override
    public void deleteEtudiant(Long id) {

    }

    @Override
    public EtudiantDTO getEtudiantAvecFiliere(Long id) {
        Etudiant etudiant = getEtudiant(id);
        FiliereDTO filiereDTO = webClient.get()
                .uri("http://MSFILIERE/api/filiere/"+etudiant.getIdFiliere())
                .retrieve()
                .bodyToMono(FiliereDTO.class)
                .block();

        EtudiantDTO etudiantDTO = new EtudiantDTO();
        BeanUtils.copyProperties(etudiant, etudiantDTO);
        etudiantDTO.setFiliere(filiereDTO);
        return etudiantDTO;
    }
}
