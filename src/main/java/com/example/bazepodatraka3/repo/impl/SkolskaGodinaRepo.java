package com.example.bazepodatraka3.repo.impl;

import com.example.bazepodatraka3.model.SkolskaGodina;
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
public class SkolskaGodinaRepo implements BPRepo<SkolskaGodina, Long>, RowMapper<SkolskaGodina> {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<SkolskaGodina> findAll() {
        return jdbcTemplate.query("SELECT * FROM skolska_godina", this);
    }

    @Override
    public void save(SkolskaGodina entity) {
        jdbcTemplate.update("INSERT INTO skolska_godina (godina) VALUES (?)", entity.getGodina());
    }

    @Override
    public void deleteById(Long aLong) {
        jdbcTemplate.update("DELETE FROM skolska_godina WHERE id = ?", aLong);
    }

    @Override
    public void update(Long oldEntityId, SkolskaGodina newEntity) {
        jdbcTemplate.update("UPDATE skolska_godina SET godina = ? WHERE id = ?", newEntity.getGodina(), oldEntityId);
    }

    @Override
    public SkolskaGodina mapRow(ResultSet rs, int rowNum) throws SQLException {
        return SkolskaGodina.builder()
                .id(rs.getLong("id"))
                .godina(rs.getInt("godina"))
                .build();
    }
}
