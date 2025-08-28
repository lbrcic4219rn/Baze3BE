package com.example.bazepodatraka3.model.aktivnostplana;

import com.example.bazepodatraka3.model.personalizovaniprogram.PersonalizovaniProgramId;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AktivnostPlanaId {
    private PersonalizovaniProgramId personalizovanogProgramaId;
    private Long idAktivnosti;
}
