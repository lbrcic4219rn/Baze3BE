package com.example.bazepodatraka3.model;

public class Iop {
    //--IOP(DelovodniBroj, IdUčenika)
    //CREATE TABLE iop (
    //    delovodni_broj INT PRIMARY KEY,
    //    id_ucenika INT,
    //    FOREIGN KEY (id_ucenika) REFERENCES ucenik(id) ON DELETE CASCADE
    //);

    private Long delovodniBroj;
    private Ucenik ucenik;
}
