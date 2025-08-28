package com.example.bazepodatraka3.model.vrednovanjeaktivnostiplana;

import com.example.bazepodatraka3.model.aktivnostplana.AktivnostPlanaId;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class VrednovanjeAktivnostiPlanaId {
    private Long id;
    private AktivnostPlanaId aktivnostPlanaId;
    private Date datumProvere;
}
