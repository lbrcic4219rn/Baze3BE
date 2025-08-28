package com.example.bazepodatraka3.model.medicinskadokumenta;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicinskiDokument {
    private MedicinskiDokumentId id;
    private String medicinskiDokument;
}
