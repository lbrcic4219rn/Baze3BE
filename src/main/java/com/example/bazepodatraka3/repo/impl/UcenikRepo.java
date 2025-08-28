package com.example.bazepodatraka3.repo.impl;

import com.example.bazepodatraka3.model.adresa.Adresa;
import com.example.bazepodatraka3.model.adresa.AdresaId;
import com.example.bazepodatraka3.model.Ucenik;
import com.example.bazepodatraka3.repo.BPRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UcenikRepo implements BPRepo<Ucenik, Long>, RowMapper<Ucenik> {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Ucenik> findAll() {
        return jdbcTemplate.query("SELECT * FROM ucenik", this);
    }

    @Override
    public void save(Ucenik entity) {
        jdbcTemplate.update(
                "INSERT INTO ucenik (ime, prezime, jmbg, datum_rodjenja, ime_staratelja, prezime_staratelja, da_li_postoji_rizik_od_napustanja_nastave, id_ulice_staratelja, id_grada_staratelja, id_ulice, id_grada) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                entity.getIme(),
                entity.getPrezime(),
                entity.getJmbg(),
                java.sql.Date.valueOf(String.valueOf(entity.getDatumRodjenja())),
                entity.getImeStaratelja(),
                entity.getPrezimeStaratelja(),
                entity.isDaLiPostojiRizikOdNapustanjaNastave(),
                entity.getAdresaId().getId(),
                entity.getAdresaId().getGradId(),
                entity.getAdresaId().getId(),
                entity.getAdresaId().getGradId()
        );
    }

    @Override
    public void deleteById(Long aLong) {
        jdbcTemplate.update("DELETE FROM ucenik WHERE id = ?", aLong);
    }

    @Override
    public void update(Long oldEntityId, Ucenik newEntity) {
        jdbcTemplate.update("UPDATE ucenik SET ime = ?, prezime = ?, jmbg = ?, datum_rodjenja = ?, ime_staratelja = ?, prezime_staratelja = ?, da_li_postoji_rizik_od_napustanja_nastave = ?, id_ulice_staratelja = ?, id_grada_staratelja = ?, id_ulice = ?, id_grada = ? WHERE id = ?",
                newEntity.getIme(),
                newEntity.getPrezime(),
                newEntity.getJmbg(),
                java.sql.Date.valueOf(String.valueOf(newEntity.getDatumRodjenja())),
                newEntity.getImeStaratelja(),
                newEntity.getPrezimeStaratelja(),
                newEntity.isDaLiPostojiRizikOdNapustanjaNastave(),
                newEntity.getAdresaId().getId(),
                newEntity.getAdresaId().getGradId(),
                newEntity.getAdresaId().getId(),
                newEntity.getAdresaId().getGradId(),
                oldEntityId);
    }

    @Override
    public Ucenik mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Ucenik.builder()
                .id(rs.getLong("id"))
                .ime(rs.getString("ime"))
                .prezime(rs.getString("prezime"))
                .jmbg(rs.getString("jmbg"))
                .datumRodjenja(rs.getDate("datum_rodjenja"))
                .imeStaratelja(rs.getString("ime_staratelja"))
                .prezimeStaratelja(rs.getString("prezime_staratelja"))
                .daLiPostojiRizikOdNapustanjaNastave(rs.getBoolean("da_li_postoji_rizik_od_napustanja_nastave"))
                .adresaStarateljaId(AdresaId.builder()
                    .id(rs.getLong("id_ulice_staratelja"))
                    .gradId(rs.getLong("id_grada_staratelja"))
                    .build())
                .adresaId(AdresaId.builder()
                        .id(rs.getLong("id_ulice"))
                        .gradId(rs.getLong("id_grada"))
                        .build())
                .build();
    }
}
