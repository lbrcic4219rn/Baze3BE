package com.example.bazepodatraka3.repo.impl;

import com.example.bazepodatraka3.model.odeljenje.Odeljenje;
import com.example.bazepodatraka3.model.odeljenje.OdeljenjeId;
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
public class OdeljenjeRepo implements BPRepo<Odeljenje, OdeljenjeId>, RowMapper<Odeljenje> {

    private final JdbcTemplate jdbcTemplate;


    @Override
    public List<Odeljenje> findAll() {
        return jdbcTemplate.query("SELECT * FROM odeljenje", this);
    }

    @Override
    public void save(Odeljenje entity) {
        jdbcTemplate.update("INSERT INTO odeljenje (id_skolske_ustanove, broj_odeljenja, odeljenski_staresina) VALUES (?, ?, ?)", entity.getId().getSkolskaUstanovaId(), entity.getBrojOdeljenja(), entity.getOdeljenskiStaresinaId());
    }

    @Override
    public void deleteById(OdeljenjeId odeljenjeId) {
        jdbcTemplate.update("DELETE FROM odeljenje WHERE id = ? AND id_skolske_ustanove = ?", odeljenjeId.getId(), odeljenjeId.getSkolskaUstanovaId());
    }

    @Override
    public void update(OdeljenjeId oldEntityId, Odeljenje newEntity) {
        jdbcTemplate.update("UPDATE odeljenje SET broj_odeljenja = ?, odeljenski_staresina = ? WHERE id = ? AND id_skolske_ustanove = ?", newEntity.getBrojOdeljenja(), newEntity.getOdeljenskiStaresinaId(), oldEntityId.getId(), oldEntityId.getSkolskaUstanovaId());
    }

    @Override
    public Odeljenje mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Odeljenje.builder()
                .id(OdeljenjeId.builder()
                        .id(rs.getLong("id"))
                        .skolskaUstanovaId(rs.getLong("id_skolske_ustanove"))
                        .build())
                .brojOdeljenja(rs.getInt("broj_odeljenja"))
                .odeljenskiStaresinaId(rs.getLong("odeljenski_staresina"))
                .build();
    }
}
