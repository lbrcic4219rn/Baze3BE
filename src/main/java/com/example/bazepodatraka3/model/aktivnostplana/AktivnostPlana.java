package com.example.bazepodatraka3.model.aktivnostplana;

import com.example.bazepodatraka3.model.Zaposleni;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AktivnostPlana {
    private AktivnostPlanaId id;
    private int trajanje;
    private String ishod;
    private String nacinProvere;
    private Long zaposleniId;
}
