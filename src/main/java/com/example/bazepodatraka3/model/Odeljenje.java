package com.example.bazepodatraka3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Odeljenje {
    private Long id;
    private SkolskaUstanova skolskaUstanova;
    private Integer brojOdeljenja;
    private String nazivSkole;
    private Zaposleni odeljenskiStaresina;
}
