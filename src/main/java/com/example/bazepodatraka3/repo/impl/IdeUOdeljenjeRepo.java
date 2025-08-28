package com.example.bazepodatraka3.repo.impl;

import com.example.bazepodatraka3.model.Ideuodeljenje.IdeUOdeljenje;
import com.example.bazepodatraka3.model.Ideuodeljenje.IdeUOdeljenjeId;
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
public class IdeUOdeljenjeRepo implements BPRepo<IdeUOdeljenje, IdeUOdeljenjeId>, RowMapper<IdeUOdeljenje> {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<IdeUOdeljenje> findAll() {
        return jdbcTemplate.query("SELECT * FROM ide_u_odeljenje", this);
    }

    @Override
    public void save(IdeUOdeljenje entity) {
        jdbcTemplate.update("INSERT INTO ide_u_odeljenje (id_ucenika, id_odeljenja, id_skolske_ustanove, id_skolske_godine) VALUES (?, ?, ?, ?)", entity.getId().getIdUcenika(), entity.getId().getOdeljenjeId().getId(), entity.getId().getOdeljenjeId().getSkolskaUstanovaId(), entity.getId().getIdSkolskeGodine());
    }

    @Override
    public void deleteById(IdeUOdeljenjeId ideUOdeljenjeId) {
        jdbcTemplate.update("DELETE FROM ide_u_odeljenje WHERE id_ucenika = ? AND id_odeljenja = ? AND id_skolske_ustanove = ? AND id_skolske_godine = ?", ideUOdeljenjeId.getIdUcenika(), ideUOdeljenjeId.getOdeljenjeId().getId(), ideUOdeljenjeId.getOdeljenjeId().getSkolskaUstanovaId(), ideUOdeljenjeId.getIdSkolskeGodine());
    }

    @Override
    public void update(IdeUOdeljenjeId oldEntityId, IdeUOdeljenje newEntity) {
        jdbcTemplate.update("UPDATE ide_u_odeljenje SET id_ucenika = ?, id_odeljenja = ?, id_skolske_ustanove = ?, id_skolske_godine = ? WHERE id_ucenika = ? AND id_odeljenja = ? AND id_skolske_ustanove AND id_skolske_godine = ?", newEntity.getId().getIdUcenika(), newEntity.getId().getOdeljenjeId().getId(), newEntity.getId().getOdeljenjeId().getSkolskaUstanovaId(), newEntity.getId().getIdSkolskeGodine(), oldEntityId.getIdUcenika(), oldEntityId.getOdeljenjeId().getId(), oldEntityId.getOdeljenjeId().getSkolskaUstanovaId(), oldEntityId.getIdSkolskeGodine());
    }

    @Override
    public IdeUOdeljenje mapRow(ResultSet rs, int rowNum) throws SQLException {
        return IdeUOdeljenje.builder()
                .id(IdeUOdeljenjeId.builder()
                        .idUcenika(rs.getLong("id_ucenika"))
                        .odeljenjeId(OdeljenjeId.builder()
                                .skolskaUstanovaId(rs.getLong("id_skolske_ustanove"))
                                .id(rs.getLong("id_odeljenja"))
                                .build())
                        .idSkolskeGodine(rs.getLong("id_skolske_godine"))
                        .build())
                .build();
    }
}
