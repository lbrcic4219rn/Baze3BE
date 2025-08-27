package com.example.bazepodatraka3.model.personalizovaniprogram;

import com.example.bazepodatraka3.model.planmeraindividualizacije.PlanMeraIndividualizacije;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonalizovaniProgram {
    private PersonalizovaniProgramId id;
    private String cilj;
    private PlanMeraIndividualizacije planMeraIndividualizacije;
}
