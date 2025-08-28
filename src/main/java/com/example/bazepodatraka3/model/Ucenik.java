package com.example.bazepodatraka3.model;

import com.example.bazepodatraka3.model.adresa.Adresa;
import com.example.bazepodatraka3.model.adresa.AdresaId;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Ucenik {
    private Long id;
    private String jmbg; //TO_DO check
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String imeStaratelja;
    private String prezimeStaratelja;
    private boolean daLiPostojiRizikOdNapustanjaNastave;
    private Long odeljenskiStaresinaId;
    private AdresaId adresaId;
    private AdresaId adresaStarateljaId;
}
