package com.example.bazepodatraka3.model.odeljenje;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OdeljenjeId {
    private Long id;
    private Long skolskaUstanovaId;
}
