package com.example.bazepodatraka3.model.saglasnost;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaglasnostId {
    private Long id;
    private Long idSkolskeGodine;
    private Long idUcenika;
}
