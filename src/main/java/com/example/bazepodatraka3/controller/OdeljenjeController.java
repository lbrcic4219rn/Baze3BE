package com.example.bazepodatraka3.controller;

import com.example.bazepodatraka3.model.odeljenje.Odeljenje;
import com.example.bazepodatraka3.model.odeljenje.OdeljenjeId;
import com.example.bazepodatraka3.repo.impl.OdeljenjeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("odeljenje")
@RequiredArgsConstructor
@CrossOrigin
public class OdeljenjeController {
    private final OdeljenjeRepo odeljenjeRepo;

    @GetMapping
    public Object getAll() {
        return odeljenjeRepo.findAll();
    }

    @PostMapping
    public void addOdeljenje(@RequestBody Odeljenje odeljenje) {
        odeljenjeRepo.save(odeljenje);
    }

    @DeleteMapping
    public void deleteOdeljenje(@RequestParam Long id, @RequestParam Long skolskaUstanovaId) {
        odeljenjeRepo.deleteById(OdeljenjeId.builder().id(id).skolskaUstanovaId(skolskaUstanovaId).build());
    }

    @PutMapping
    public void updateOdeljenje(@RequestParam Long oldId, @RequestParam Long oldSkolskaUstanovaId, @RequestBody Odeljenje newOdeljenje) {
        odeljenjeRepo.update(OdeljenjeId.builder().id(oldId).skolskaUstanovaId(oldSkolskaUstanovaId).build(), newOdeljenje);
    }
}
