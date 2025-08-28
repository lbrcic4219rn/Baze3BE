package com.example.bazepodatraka3.repo.impl;

import com.example.bazepodatraka3.model.Vestina;
import com.example.bazepodatraka3.repo.BPRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class VestinaRepo implements BPRepo<Vestina, Long>, RowMapper<Vestina> {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Vestina mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
        return Vestina.builder()
                .id(rs.getLong("id"))
                .naziv(rs.getString("naziv"))
                .opis(rs.getString("opis"))
                .build();
    }

    @Override
    public List<Vestina> findAll() {
        return jdbcTemplate.query("SELECT * FROM vestina", this);
    }

    @Override
    public void save(Vestina entity) {
        jdbcTemplate.update("INSERT INTO vestina (naziv, opis) VALUES (?, ?)", entity.getNaziv(), entity.getOpis());
    }

    @Override
    public void deleteById(Long aLong) {
        jdbcTemplate.update("DELETE FROM vestina WHERE id = ?", aLong);
    }

    @Override
    public void update(Long oldEntityId, Vestina newEntity) {
        jdbcTemplate.update("UPDATE vestina SET naziv = ?, opis = ? WHERE id = ?", newEntity.getNaziv(), newEntity.getOpis(), oldEntityId);
    }
}
