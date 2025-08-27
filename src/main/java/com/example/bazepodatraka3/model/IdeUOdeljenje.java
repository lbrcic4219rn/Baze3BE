package com.example.bazepodatraka3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IdeUOdeljenje {
    private Long idUcenika;
    private Long idOdeljenja;
    private Long idSkolskeUstanove;
    private Long idSkolskeGodine;
}
