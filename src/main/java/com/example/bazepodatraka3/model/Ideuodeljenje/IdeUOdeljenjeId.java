package com.example.bazepodatraka3.model.Ideuodeljenje;

import com.example.bazepodatraka3.model.odeljenje.OdeljenjeId;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IdeUOdeljenjeId {
    private Long idUcenika;
    private OdeljenjeId odeljenjeId;
    private Long idSkolskeGodine;
}
