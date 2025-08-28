package com.example.bazepodatraka3.model.odeljenje;

import com.example.bazepodatraka3.model.SkolskaUstanova;
import com.example.bazepodatraka3.model.Zaposleni;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Odeljenje {
    private OdeljenjeId id;
    private Integer brojOdeljenja;
    private String nazivSkole;
    private Long odeljenskiStaresinaId;
}
