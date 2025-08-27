package com.example.bazepodatraka3.model.procenapedagoskogprofila;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProcenaPedagoskogProfila {
    private  ProcenaPedagoskogProfilaId id;
    private String jakeStrane;
    private String potrebaZaPodrskom;
}
