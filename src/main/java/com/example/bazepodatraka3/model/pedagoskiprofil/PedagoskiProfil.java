package com.example.bazepodatraka3.model.pedagoskiprofil;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PedagoskiProfil {
    private PedagoskiProfilId pedagoskiProfilId;
    private Date datumIzrade;
}
