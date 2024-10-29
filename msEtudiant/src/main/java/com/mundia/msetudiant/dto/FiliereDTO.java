package com.mundia.msetudiant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FiliereDTO {
    private Long id;
    private String titre;
    private String cycle;
}
