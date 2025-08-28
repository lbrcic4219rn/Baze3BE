package com.example.bazepodatraka3.controller;

import com.example.bazepodatraka3.repo.BPRepo;
import com.example.bazepodatraka3.repo.impl.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class GenericController {
    private final Map<String, BPRepo<?, ?>> repoMap;

    public GenericController(
            AdresaRepo adresaRepo,
            GradRepo gradRepo,
            IdeUOdeljenjeRepo ideUOdeljenjeRepo,
            OblastRepo oblastRepo,
            OdeljenjeRepo odeljenjeRepo,
            SkolskaGodinaRepo skolskaGodinaRepo,
            SkolskaUstanovaRepo skolskaUstanovaRepo,
            UcenikRepo ucenikRepo,
            VestinaRepo vestinaRepo,
            ZaposleniRepo zaposleniRepo
    ) {
        this.repoMap = Map.of(
            // Add your repositories here, for example:
            // "grad": gradRepo,
            // "oblast": oblastRepo,
            // "planMeraIndividualizacije": planMeraIndividualizacijeRepo,
            // "vrednovanjeAktivnostiPlana": vrednovanjeAktivnostiPlanaRepo
        );
    }

    @GetMapping("/{type}")
    public ResponseEntity<List<?>> findAll(String type) {
        BPRepo<?, ?> repo = repoMap.get(type);
        if (repo == null) {
            return ResponseEntity.badRequest().build();
        }
        List<?> results = repo.findAll();
        return ResponseEntity.ok(results);
    }

    @PostMapping("/{type}")
    public ResponseEntity<Void> save(@PathVariable String type, @RequestBody Object entity) {
        @SuppressWarnings("unchecked")
        BPRepo<Object, Object> repo = (BPRepo<Object, Object>) repoMap.get(type);
        if (repo == null) {
            return ResponseEntity.badRequest().build();
        }
        repo.save(entity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{type}")
    public ResponseEntity<Void> deleteById(@PathVariable String type, @RequestBody Object id) {
        @SuppressWarnings("unchecked")
        BPRepo<Object, Object> repo = (BPRepo<Object, Object>) repoMap.get(type);
        if (repo == null) {
            return ResponseEntity.badRequest().build();
        }
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{type}")
    public ResponseEntity<Void> update(@PathVariable String type, @RequestBody Map<String, Object> request) {
        @SuppressWarnings("unchecked")
        BPRepo<Object, Object> repo = (BPRepo<Object, Object>) repoMap.get(type);
        if (repo == null) {
            return ResponseEntity.badRequest().build();
        }
        Object oldId = request.get("oldId");
        Object newEntity = request.get("newEntity");
        repo.update(oldId, newEntity);
        return ResponseEntity.ok().build();
    }
}
