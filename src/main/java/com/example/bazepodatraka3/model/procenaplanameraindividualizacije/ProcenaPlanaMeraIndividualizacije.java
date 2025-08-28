package com.example.bazepodatraka3.model.procenaplanameraindividualizacije;

import com.example.bazepodatraka3.model.VrstaPodrske;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProcenaPlanaMeraIndividualizacije {
    private ProcenaPlanaMeraIndividualizacijeId id;
    private Long vrstaPodrskeId;
}
