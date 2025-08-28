package com.example.bazepodatraka3.repo.impl;

import com.example.bazepodatraka3.model.adresa.Adresa;
import com.example.bazepodatraka3.model.adresa.AdresaId;
import com.example.bazepodatraka3.model.SkolskaUstanova;
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
public class SkolskaUstanovaRepo implements BPRepo<SkolskaUstanova, Long>, RowMapper<SkolskaUstanova> {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<SkolskaUstanova> findAll() {
        return jdbcTemplate.query("SELECT * FROM skolska_ustanova", this);
    }

    @Override
    public void save(SkolskaUstanova entity) {
        jdbcTemplate.update("INSERT INTO skolska_ustanova (naziv, id_ulice, id_grada, direktor) VALUES (?, ?, ?, ?)", entity.getNaziv(), entity.getAdresaId().getId(), entity.getAdresaId().getGradId(), entity.getDirektorId());
    }

    @Override
    public void deleteById(Long skolskaUstanova) {
        jdbcTemplate.update("DELETE FROM skolska_ustanova WHERE id = ?", skolskaUstanova);
    }

    @Override
    public void update(Long oldEntityId, SkolskaUstanova newEntity) {
        jdbcTemplate.update("UPDATE skolska_ustanova SET naziv = ?, id_ulice = ?, id_grada = ?, direktor = ? WHERE id = ?", newEntity.getNaziv(), newEntity.getAdresaId().getId(), newEntity.getAdresaId().getGradId(), newEntity.getDirektorId(), oldEntityId);
    }

    @Override
    public SkolskaUstanova mapRow(ResultSet rs, int rowNum) throws SQLException {
        return SkolskaUstanova.builder()
                .id(rs.getLong("id"))
                .naziv(rs.getString("naziv"))
                .adresaId(AdresaId.builder()
                            .id(rs.getLong("id_ulice"))
                            .gradId(rs.getLong("id_grada"))
                            .build())
                .direktorId(rs.getLong("direktor"))
                .build();
    }
}
