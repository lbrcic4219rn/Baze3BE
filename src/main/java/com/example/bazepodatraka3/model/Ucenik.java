package com.example.bazepodatraka3.model;

import lombok.Data;

import java.util.Date;

public class Ucenik {
    private Long id;
    private String jmbg; //TO_DO check
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String imeStaratelja;
    private String prezimeStaratelja;
    private Boolean daLiPostojiRizikOdNapuštanjaNastave;
    private Adresa adresa;
    private Adresa adresaStaratelja;
}
