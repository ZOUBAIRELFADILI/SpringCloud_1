package com.mundia.msetudiant.repositories;

import com.mundia.msetudiant.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepo extends JpaRepository<Etudiant, Long> {
    List<Etudiant> findAllByNom(String nom);
   List<Etudiant> findAllByIdFiliere(Long idFilier);

}
