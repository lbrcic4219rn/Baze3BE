package com.example.bazepodatraka3.repo.impl;

import com.example.bazepodatraka3.model.adresa.Adresa;
import com.example.bazepodatraka3.model.adresa.AdresaId;
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
public class AdresaRepo implements BPRepo<Adresa, AdresaId>, RowMapper<Adresa> {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Adresa> findAll() {
        return  jdbcTemplate.query("SELECT * FROM adresa", this);
    }

    @Override
    public void save(Adresa entity) {
        jdbcTemplate.update("INSERT INTO adresa (id, id_grada, naziv_ulice) VALUES (?, ?, ?)", this, entity.getAdresaId().getId(), entity.getAdresaId().getGradId(), entity.getNazivUlice());
    }

    @Override
    public void deleteById(AdresaId adresaId) {
        jdbcTemplate.update("DELETE FROM adresa WHERE id = ? AND id_grada = ?", adresaId.getId(), adresaId.getGradId());
    }

    @Override
    public void update(AdresaId oldEntityId, Adresa newEntity) {
        jdbcTemplate.update("UPDATE adresa SET naziv_ulice = ? WHERE id = ? AND id_grada = ?", newEntity.getNazivUlice(), oldEntityId.getId(), oldEntityId.getGradId());
    }

    @Override
    public Adresa mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Adresa.builder()
                .adresaId(AdresaId.builder()
                        .id(rs.getLong("id"))
                        .gradId(rs.getLong("id_grada"))
                        .build())
                .nazivUlice(rs.getString("naziv_ulice"))
                .build();
    }
}
