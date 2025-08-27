package com.example.bazepodatraka3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Adresa {
    private Long id;
    private Grad grad;
    private String nazivUlice;
}
