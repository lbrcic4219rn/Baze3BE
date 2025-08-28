package com.example.bazepodatraka3.controller;

import com.example.bazepodatraka3.model.SkolskaGodina;
import com.example.bazepodatraka3.repo.impl.SkolskaGodinaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("skolska-godina")
@RequiredArgsConstructor
@CrossOrigin
public class SkolskaGodinaController {
    private final SkolskaGodinaRepo skolskaGodinaRepo;

    @GetMapping
    public List<SkolskaGodina> getAll() {
        return skolskaGodinaRepo.findAll();
    }

    @PostMapping
    public void addSkolskaGodina(@RequestBody SkolskaGodina skolskaGodina) {
        skolskaGodinaRepo.save(skolskaGodina);
    }

    @DeleteMapping
    public void deleteSkolskaGodina(@RequestParam Long id) {
        skolskaGodinaRepo.deleteById(id);
    }

    @PutMapping
    public void updateSkolskaGodina(@RequestParam Long oldId, @RequestBody SkolskaGodina newSkolskaGodina) {
        skolskaGodinaRepo.update(oldId, newSkolskaGodina);
    }

}
