package com.example.bazepodatraka3.controller;

import com.example.bazepodatraka3.model.adresa.Adresa;
import com.example.bazepodatraka3.model.adresa.AdresaId;
import com.example.bazepodatraka3.repo.impl.AdresaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("adresa")
@RequiredArgsConstructor
@CrossOrigin
public class AdresaController {
    private final AdresaRepo adresaRepo;

    @GetMapping
    public Object getAll() {
        return adresaRepo.findAll();
    }

    @PostMapping
    public void addAdresa(@RequestBody Adresa adresa) {
        adresaRepo.save(adresa);
    }

    @DeleteMapping
    public void deleteAdresa(@RequestParam Long id, @RequestParam Long gradId) {
        adresaRepo.deleteById(AdresaId.builder().id(id).gradId(gradId).build());
    }

    @PutMapping
    public void updateAdresa(@RequestParam Long oldId, @RequestParam Long oldGradId, @RequestBody Adresa newAdresa) {
        adresaRepo.update(AdresaId.builder().id(oldId).gradId(oldGradId).build(), newAdresa);
    }
}
