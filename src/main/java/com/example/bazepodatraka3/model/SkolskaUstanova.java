package com.example.bazepodatraka3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SkolskaUstanova {
    private Long id;
    private String naziv;
    private Adresa adresa;
    private Zaposleni direktor;
}
