package com.mundia.msfiliere.web;

import com.mundia.msfiliere.dto.FiliereDTO;
import com.mundia.msfiliere.dto.FiliereReq;
import com.mundia.msfiliere.entities.Filiere;
import com.mundia.msfiliere.services.FiliereService;
import com.mundia.msfiliere.services.FiliereServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/filiere")
@RequiredArgsConstructor
public class FiliereController {
    final FiliereServiceImpl filiereService;
    //----------------------------------------------------
    @PostMapping("/add")
    public Filiere addFiliere(@RequestBody FiliereReq filiereReq) {
        return filiereService.addFiliere(filiereReq);
    }
    //----------------------------------------------------
    @GetMapping("/{id}")
    public Filiere getFiliere(@PathVariable Long id) {
       return filiereService.getFiliereById(id);
    }
    //--------------------------------------------------------
    @GetMapping("/filieres")
    public List<Filiere> getFilieres() {
        return filiereService.getAllFilieres();
    }
    //--------------------filier avec etudiants-------------
    @GetMapping("/filieretudiants/{id}")
    public FiliereDTO getFiliereWithEtu(@PathVariable Long id) {
        return filiereService.getFiliereDTOById(id);
    }
}
