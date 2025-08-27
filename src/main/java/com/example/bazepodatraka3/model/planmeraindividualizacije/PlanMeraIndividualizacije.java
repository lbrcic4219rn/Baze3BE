package com.example.bazepodatraka3.model.planmeraindividualizacije;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PlanMeraIndividualizacije {
    private PlanMeraIndividualizacijeId id;
    private Date datumIzrade;
}
