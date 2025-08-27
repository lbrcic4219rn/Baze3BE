package com.example.bazepodatraka3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SkolskaGodina {
    private Long id;
    private int godina;
}
