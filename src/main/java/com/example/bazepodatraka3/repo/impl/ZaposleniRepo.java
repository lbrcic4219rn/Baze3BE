package com.example.bazepodatraka3.repo.impl;

import com.example.bazepodatraka3.model.Zaposleni;
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
public class ZaposleniRepo implements BPRepo<Zaposleni, Long>, RowMapper<Zaposleni> {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Zaposleni> findAll() {
        return jdbcTemplate.query("SELECT * FROM zaposleni", this);
    }

    @Override
    public void save(Zaposleni entity) {
        jdbcTemplate.update("INSERT INTO zaposleni (ime, prezime) VALUES (?, ?)", entity.getIme(), entity.getPrezime());
    }

    @Override
    public void deleteById(Long aLong) {
        jdbcTemplate.update("DELETE FROM zaposleni WHERE id = ?", aLong);
    }

    @Override
    public void update(Long oldEntityId, Zaposleni newEntity) {
        jdbcTemplate.update("UPDATE zaposleni SET ime = ?, prezime = ? WHERE id = ?", newEntity.getIme(), newEntity.getPrezime(), oldEntityId);
    }

    @Override
    public Zaposleni mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Zaposleni.builder()
                .id(rs.getLong("id"))
                .ime(rs.getString("ime"))
                .prezime(rs.getString("prezime"))
                .build();
    }
}
