package com.example.bazepodatraka3.model.saglasnost;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Saglasnost {
    private SaglasnostId id;
    private Date datumSaglasnosti;
    private boolean daLiJeRoditeljSaglasan;
}
