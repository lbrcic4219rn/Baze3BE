package com.example.bazepodatraka3.model.vrednovanjeaktivnostiplana;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VrednovanjeAktivnostiPlana {
    private VrednovanjeAktivnostiPlanaId id;
    private String stepenUspesnosti;
}
