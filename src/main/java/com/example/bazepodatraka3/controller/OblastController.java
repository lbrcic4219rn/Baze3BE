package com.example.bazepodatraka3.controller;

import com.example.bazepodatraka3.model.Oblast;
import com.example.bazepodatraka3.repo.impl.OblastRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("oblast")
@RequiredArgsConstructor
@CrossOrigin
public class OblastController {
    private final OblastRepo oblastRepo;

    @GetMapping
    public List<Oblast> getAll() {
        return oblastRepo.findAll();
    }

    @PostMapping
    public void addOblast(@RequestBody Oblast oblast) {
        oblastRepo.save(oblast);
    }

    @DeleteMapping
    public void deleteOblast(@RequestParam Long id) {
        oblastRepo.deleteById(id);
    }

    @PutMapping
    public void updateOblast(@RequestParam Long oldId, @RequestBody Oblast newOblast) {
        oblastRepo.update(oldId, newOblast);
    }
}
