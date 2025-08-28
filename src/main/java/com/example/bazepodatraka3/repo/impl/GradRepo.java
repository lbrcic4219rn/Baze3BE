package com.example.bazepodatraka3.repo.impl;

import com.example.bazepodatraka3.model.Grad;
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
public class GradRepo implements BPRepo<Grad, Long>, RowMapper<Grad> {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Grad> findAll() {
        return jdbcTemplate.query("SELECT * FROM grad", this);
    }

    @Override
    public void save(Grad entity) {
        jdbcTemplate.update("INSERT INTO grad (naziv) VALUES (?)", entity.getNaziv());

    }

    @Override
    public void deleteById(Long aLong) {
        jdbcTemplate.update("DELETE FROM grad WHERE id = ?", aLong);
    }

    @Override
    public void update(Long oldEntityId, Grad newEntity) {
        jdbcTemplate.update("UPDATE grad SET naziv = ? WHERE id = ?", newEntity.getNaziv(), oldEntityId);
    }

    @Override
    public Grad mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Grad.builder()
                .id(rs.getLong("id"))
                .naziv(rs.getString("naziv"))
                .build();
    }
}
