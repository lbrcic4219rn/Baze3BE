package com.example.bazepodatraka3.repo.impl;

import com.example.bazepodatraka3.model.Oblast;
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
public class OblastRepo implements BPRepo<Oblast, Long>, RowMapper<Oblast> {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Oblast> findAll() {
        return jdbcTemplate.query("SELECT * FROM oblast", this);
    }

    @Override
    public void save(Oblast entity) {
        jdbcTemplate.update("INSERT INTO oblast (naziv) VALUES (?)", entity.getNaziv());
    }

    @Override
    public void deleteById(Long aLong) {
        jdbcTemplate.update("DELETE FROM oblast WHERE id=?", aLong);
    }

    @Override
    public void update(Long oldEntityId, Oblast newEntity) {
        jdbcTemplate.update("UPDATE oblast SET naziv=? WHERE id=?", newEntity.getNaziv(), oldEntityId);
    }

    @Override
    public Oblast mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Oblast.builder()
                .id(rs.getLong("id"))
                .naziv(rs.getString("naziv"))
                .build();
    }
}
