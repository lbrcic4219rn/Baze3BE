package com.example.bazepodatraka3.model;

import com.example.bazepodatraka3.model.adresa.AdresaId;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SkolskaUstanova {
    private Long id;
    private String naziv;
    private AdresaId adresaId;
    private Long direktorId;
}
