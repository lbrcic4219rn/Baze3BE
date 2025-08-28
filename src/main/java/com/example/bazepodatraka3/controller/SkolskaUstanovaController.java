package com.example.bazepodatraka3.controller;

import com.example.bazepodatraka3.model.SkolskaUstanova;
import com.example.bazepodatraka3.repo.impl.SkolskaUstanovaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("skolska-ustanova")
@RequiredArgsConstructor
@CrossOrigin
public class SkolskaUstanovaController {
    private final SkolskaUstanovaRepo skolskaUstanovaRepo;

    @GetMapping
    public List<SkolskaUstanova> getAll() {
        return skolskaUstanovaRepo.findAll();
    }

    @PostMapping
    public void addSkolskaUstanova(@RequestBody SkolskaUstanova skolskaUstanova) {
        skolskaUstanovaRepo.save(skolskaUstanova);
    }

    @DeleteMapping
    public void deleteSkolskaUstanova(@RequestParam Long id) {
        skolskaUstanovaRepo.deleteById(id);
    }

    @PutMapping
    public void updateSkolskaUstanova(@RequestParam Long oldId, @RequestBody SkolskaUstanova newSkolskaUstanova) {
        skolskaUstanovaRepo.update(oldId, newSkolskaUstanova);
    }
}
