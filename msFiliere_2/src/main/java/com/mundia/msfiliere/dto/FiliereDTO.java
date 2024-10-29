package com.mundia.msfiliere.dto;

import com.mundia.msfiliere.entities.Cycle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FiliereDTO {
    private Long id;
    private String titre;
    private Cycle cycle;
    private List<EtudiantDTO> etudiants;
}
