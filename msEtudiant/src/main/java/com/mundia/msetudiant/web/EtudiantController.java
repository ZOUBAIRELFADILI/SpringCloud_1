package com.mundia.msetudiant.web;

import com.mundia.msetudiant.dto.EtudiantDTO;
import com.mundia.msetudiant.dto.EtudiantReq;
import com.mundia.msetudiant.entities.Etudiant;
import com.mundia.msetudiant.services.EtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiant")
@RequiredArgsConstructor
public class EtudiantController {
    final EtudiantService etudiantService;
    //----------add--------------------------------------
    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody EtudiantReq etudiant) {
       return etudiantService.addEtudiant(etudiant);
    }
    //--------------1 etudiant--------------
    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id) {
        return etudiantService.getEtudiant(id);
    }
    //-----------list----------------------------------
    @GetMapping("/etudiants")
    public List<Etudiant> getEtudiants() {
        return etudiantService.getAllEtudiants();
    }
    //-----------etudiant avec filiere------------
    @GetMapping("/etudiantfilier/{id}")
    public EtudiantDTO getEtudiantFiliererById(@PathVariable Long id) {
        return etudiantService.getEtudiantAvecFiliere(id);
    }
    //-----------etudiant par idFilier------------
    @GetMapping("/etudiantbyidfiliere/{id}")
    public List<Etudiant> getEtudiantbyFilId(@PathVariable Long id) {
        return etudiantService.getEtudiantsByFilId(id);
    }
}
