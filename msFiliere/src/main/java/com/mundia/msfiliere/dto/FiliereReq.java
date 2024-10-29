package com.mundia.msfiliere.dto;

import com.mundia.msfiliere.entities.Cycle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FiliereReq {
    private String titre;
    private Cycle cycle;
}
