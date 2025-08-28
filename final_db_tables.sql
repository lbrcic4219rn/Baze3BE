-- Final Database Tables

-- Grad
CREATE TABLE grad (
    id SERIAL PRIMARY KEY,
    naziv VARCHAR(255) NOT NULL
);

-- Adresa
CREATE TABLE adresa (
    id SERIAL,
    id_grada INT,
    naziv_ulice VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_grada) REFERENCES grad(id) ON DELETE CASCADE,
    PRIMARY KEY (id, id_grada)
);

-- Zaposleni
CREATE TABLE zaposleni (
    id SERIAL PRIMARY KEY,
    ime VARCHAR(255) NOT NULL,
    prezime VARCHAR(255) NOT NULL
);

-- Vestina
CREATE TABLE vestina (
    id SERIAL PRIMARY KEY,
    naziv VARCHAR(255) NOT NULL,
    opis TEXT
);

-- Oblast
CREATE TABLE oblast (
    id SERIAL PRIMARY KEY,
    naziv VARCHAR(255) NOT NULL
);

-- StepenUspesnosti
CREATE TABLE stepen_uspesnosti (
    id SERIAL PRIMARY KEY,
    vrednost INT NOT NULL
);

-- SkolskaUstanova
CREATE TABLE skolska_ustanova (
    id SERIAL PRIMARY KEY,
    naziv VARCHAR(255) NOT NULL,
    id_ulice INT,
    id_grada INT,
    direktor INT NOT NULL,
    FOREIGN KEY (id_ulice, id_grada) REFERENCES adresa(id, id_grada) ON DELETE CASCADE,
    FOREIGN KEY (direktor) REFERENCES zaposleni(id)
);

-- Odeljenje
CREATE TABLE odeljenje (
    id SERIAL,
    id_skolske_ustanove INT,
    broj_odeljenja INT NOT NULL,
    odeljenski_staresina INT NOT NULL,
    naziv_skole VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_skolske_ustanove) REFERENCES skolska_ustanova(id) ON DELETE CASCADE,
    FOREIGN KEY (odeljenski_staresina) REFERENCES zaposleni(id),
    PRIMARY KEY (id, id_skolske_ustanove)
);

-- SkolskaGodina
CREATE TABLE skolska_godina (
    id SERIAL PRIMARY KEY,
    godina INT NOT NULL
);

-- Ucenik
CREATE DOMAIN jmbg_type AS VARCHAR(13)
    CHECK (VALUE ~ '^[0-9]{13}$');
CREATE TABLE ucenik (
    id SERIAL PRIMARY KEY,
    jmbg jmbg_type NOT NULL,
    ime VARCHAR(255) NOT NULL,
    prezime VARCHAR(255) NOT NULL,
    datum_rodjenja DATE NOT NULL,
    ime_staratelja VARCHAR(255) NOT NULL,
    prezime_staratelja VARCHAR(255) NOT NULL,
    da_li_postoji_rizik_od_napustanja_nastave BOOLEAN NOT NULL,
    id_ulice INT NOT NULL,
    id_grada INT NOT NULL,
    id_ulice_staratelja INT,
    id_grada_staratelja INT,
    FOREIGN KEY (id_ulice, id_grada) REFERENCES adresa(id, id_grada),
    FOREIGN KEY (id_ulice_staratelja, id_grada_staratelja) REFERENCES adresa(id, id_grada)
);

-- Ucenik Ostali Podaci
CREATE TABLE ucenik_ostali_podaci (
    id_ucenika SERIAL PRIMARY KEY,
    id_ulice INT NOT NULL,
    id_grada INT NOT NULL,
    id_ulice_staratelja INT,
    id_grada_staratelja INT,
    ime_staratelja VARCHAR(255) NOT NULL,
    prezime_staratelja VARCHAR(255) NOT NULL,
    da_li_postoji_rizik_od_napustanja_nastave BOOLEAN NOT NULL,
    odeljenjski_staresina INT,
    FOREIGN KEY (id_ulice, id_grada) REFERENCES adresa(id, id_grada),
    FOREIGN KEY (id_ulice_staratelja, id_grada_staratelja) REFERENCES adresa(id, id_grada),
    FOREIGN KEY (odeljenjski_staresina) REFERENCES zaposleni(id)
);

-- IdeUOdeljenje
CREATE TABLE ide_u_odeljenje (
    id_ucenika INT,
    id_odeljenja INT,
    id_skolske_ustanove INT,
    id_skolske_godine INT,
    FOREIGN KEY (id_ucenika) REFERENCES ucenik_ostali_podaci(id_ucenika),
    FOREIGN KEY (id_odeljenja, id_skolske_ustanove) REFERENCES odeljenje(id, id_skolske_ustanove) ON DELETE CASCADE,
    FOREIGN KEY (id_skolske_godine) REFERENCES skolska_godina(id) ON DELETE CASCADE,
    PRIMARY KEY (id_ucenika, id_odeljenja, id_skolske_ustanove, id_skolske_godine)
);

-- IOP
CREATE TABLE iop (
    delovodni_broj INT PRIMARY KEY,
    id_ucenika INT,
    FOREIGN KEY (id_ucenika) REFERENCES ucenik(id) ON DELETE CASCADE
);

-- TimZaDodatnuPodrsku
CREATE TABLE tim_za_dodatnu_podrsku (
    delovodni_broj INT,
    id_zaposlenog INT,
    pozicija VARCHAR(255) NOT NULL,
    FOREIGN KEY (delovodni_broj) REFERENCES iop(delovodni_broj) ON DELETE CASCADE,
    FOREIGN KEY (id_zaposlenog) REFERENCES zaposleni(id) ON DELETE CASCADE,
    PRIMARY KEY (delovodni_broj, id_zaposlenog)
);

-- PedagoskiProfil
CREATE TABLE pedagoski_profil (
    id SERIAL,
    id_ucenika INT,
    datum_izrade DATE NOT NULL,
    FOREIGN KEY (id_ucenika) REFERENCES ucenik(id) ON DELETE CASCADE,
    PRIMARY KEY (id, id_ucenika)
);

-- ProcenaPedagoskogProfila
CREATE TABLE procena_pedagoskog_profila (
    id_pedagoskog_profila INT,
    id_ucenika INT,
    id_vestine INT,
    jake_strane TEXT,
    potreba_za_podrskom TEXT,
    FOREIGN KEY (id_pedagoskog_profila, id_ucenika) REFERENCES pedagoski_profil(id, id_ucenika) ON DELETE CASCADE,
    FOREIGN KEY (id_vestine) REFERENCES vestina(id),
    PRIMARY KEY (id_pedagoskog_profila, id_ucenika, id_vestine)
);

-- Saglasnost
CREATE TABLE saglasnost (
    id SERIAL,
    id_skolske_godine INT,
    id_ucenika INT,
    datum_saglasnosti DATE NOT NULL,
    da_li_je_roditelj_saglasan BOOLEAN NOT NULL,
    FOREIGN KEY (id_skolske_godine) REFERENCES skolska_godina(id) ON DELETE CASCADE,
    FOREIGN KEY (id_ucenika) REFERENCES ucenik(id) ON DELETE CASCADE,
    PRIMARY KEY (id, id_skolske_godine, id_ucenika)
);

-- PlanMeraIndividualizacije
CREATE TABLE plan_mera_individualizacije (
    id SERIAL,
    id_ucenika INT,
    datum_izrade DATE NOT NULL,
    FOREIGN KEY (id_ucenika) REFERENCES ucenik(id) ON DELETE CASCADE,
    PRIMARY KEY (id, id_ucenika)
);

-- VrstaPodrske
CREATE TABLE vrsta_podrske (
    id SERIAL PRIMARY KEY,
    naziv VARCHAR(255) NOT NULL,
    opis TEXT
);

-- ProcenaPlanaMeraIndividualizacije
CREATE TABLE procena_plana_mera_individualizacije (
    id_plan_mera_individualizacije INT,
    id_ucenika INT,
    id_procene SERIAL,
    id_vrste_podrske INT,
    FOREIGN KEY (id_plan_mera_individualizacije, id_ucenika) REFERENCES plan_mera_individualizacije(id, id_ucenika) ON DELETE CASCADE,
    FOREIGN KEY (id_vrste_podrske) REFERENCES vrsta_podrske(id),
    PRIMARY KEY (id_plan_mera_individualizacije, id_ucenika, id_procene)
);

-- PersonalizovaniProgram
CREATE TABLE personalizovani_program (
    id SERIAL,
    id_oblasti INT,
    cilj TEXT NOT NULL,
    id_plana_mera_individualizacije INT,
    id_ucenika INT,
    id_procene INT,
    FOREIGN KEY (id_oblasti) REFERENCES oblast(id),
    FOREIGN KEY (id_plana_mera_individualizacije, id_ucenika, id_procene) REFERENCES procena_plana_mera_individualizacije(id_plan_mera_individualizacije, id_ucenika, id_procene),
    PRIMARY KEY (id, id_oblasti)
);

-- AktivnostPlana
CREATE TABLE aktivnost_plana (
    id_programa INT,
    id_oblasti INT,
    id_aktivnosti SERIAL,
    trajanje INT NOT NULL,
    ishod TEXT NOT NULL,
    nacin_provere TEXT NOT NULL,
    id_zaposlenog INT,
    ime_zaposlenog VARCHAR(255) NOT NULL,
    prezime_zaposlenog VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_programa, id_oblasti) REFERENCES personalizovani_program(id, id_oblasti),
    FOREIGN KEY (id_zaposlenog) REFERENCES zaposleni(id) ON DELETE CASCADE,
    PRIMARY KEY (id_programa, id_oblasti, id_aktivnosti)
);

-- StepenUspesnostiAktivnosti ENUM
CREATE TYPE stepen_uspesnosti_aktivnosti AS ENUM ('neuspesno', 'uspesno', 'delimicno_uspesno');

-- VrednovanjeAktivnostiPlana
CREATE TABLE vrednovanje_aktivnosti_plana (
    id_programa INT,
    id_oblasti INT,
    id_aktivnosti INT,
    datum_provere DATE NOT NULL,
    stepen_uspesnosti stepen_uspesnosti_aktivnosti,
    id SERIAL,
    FOREIGN KEY (id_programa, id_oblasti, id_aktivnosti) REFERENCES aktivnost_plana(id_programa, id_oblasti, id_aktivnosti),
    PRIMARY KEY (id, id_programa, id_aktivnosti, id_oblasti, datum_provere)
);

-- MedicinskiDokument TYPE
CREATE TYPE medicinski_dokument AS (
    datum_podnosenja DATE,
    naziv VARCHAR(255),
    izvor VARCHAR(255),
    lokacija_dokumenta VARCHAR(255)
);

-- MedicinskaDokumenta
CREATE TABLE medicinska_dokumenta (
    id SERIAL,
    id_ucenika INT,
    dokument medicinski_dokument,
    FOREIGN KEY (id_ucenika) REFERENCES ucenik(id) ON DELETE CASCADE,
    PRIMARY KEY (id, id_ucenika)
);

