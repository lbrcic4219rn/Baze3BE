package com.example.bazepodatraka3.controller;

import com.example.bazepodatraka3.model.Zaposleni;
import com.example.bazepodatraka3.repo.impl.ZaposleniRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("zaposleni")
@RequiredArgsConstructor
@CrossOrigin
public class ZaposleniController {
    private final ZaposleniRepo zaposleniRepo;

    @GetMapping
    public List<Zaposleni> getAll() {
        return zaposleniRepo.findAll();
    }

    @PostMapping
    public void addZaposleni(@RequestBody Zaposleni zaposleni) {
        zaposleniRepo.save(zaposleni);
    }

    @DeleteMapping
    public void deleteZaposleni(@RequestParam Long id) {
        zaposleniRepo.deleteById(id);
    }

    @PutMapping
    public void updateZaposleni(@RequestParam Long oldId, @RequestBody Zaposleni newZaposleni) {
        zaposleniRepo.update(oldId, newZaposleni);
    }
}
