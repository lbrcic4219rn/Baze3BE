package com.example.bazepodatraka3.model.adresa;

import com.example.bazepodatraka3.model.Grad;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Adresa {
    private AdresaId adresaId;
    private String nazivUlice;
}
