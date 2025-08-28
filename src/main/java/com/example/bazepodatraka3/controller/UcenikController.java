package com.example.bazepodatraka3.controller;

import com.example.bazepodatraka3.model.Ucenik;
import com.example.bazepodatraka3.repo.impl.UcenikRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ucenik")
@RequiredArgsConstructor
@CrossOrigin
public class UcenikController {
    private final UcenikRepo ucenikRepo;

    @GetMapping
    public List<Ucenik> getAll() {
        return ucenikRepo.findAll();
    }

    @PostMapping
    public void addUcenik(@RequestBody Ucenik ucenik) {
        ucenikRepo.save(ucenik);
    }

    @DeleteMapping
    public void deleteUcenik(@RequestParam Long id) {
        ucenikRepo.deleteById(id);
    }

    @PutMapping
    public void updateUcenik(@RequestParam Long oldId, @RequestBody Ucenik newUCenik) {
        ucenikRepo.update(oldId, newUCenik);
    }
}
