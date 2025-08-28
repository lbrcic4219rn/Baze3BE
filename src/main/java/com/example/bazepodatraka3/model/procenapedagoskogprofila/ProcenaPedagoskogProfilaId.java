package com.example.bazepodatraka3.model.procenapedagoskogprofila;

import com.example.bazepodatraka3.model.pedagoskiprofil.PedagoskiProfilId;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProcenaPedagoskogProfilaId {
    private PedagoskiProfilId pedagoskiProfilId;
    private Long idVeste;
}
