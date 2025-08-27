package com.example.bazepodatraka3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vestina {
    private Long id;
    private String naziv;
    private String opis;
}
