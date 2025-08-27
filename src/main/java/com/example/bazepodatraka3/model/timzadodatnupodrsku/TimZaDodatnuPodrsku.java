package com.example.bazepodatraka3.model.timzadodatnupodrsku;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TimZaDodatnuPodrsku {
    private TimZaDodatnuPodrskuId id;
    private String pozicija;
}
