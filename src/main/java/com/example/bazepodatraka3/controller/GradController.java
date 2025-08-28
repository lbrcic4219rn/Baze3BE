package com.example.bazepodatraka3.controller;

import com.example.bazepodatraka3.model.Grad;
import com.example.bazepodatraka3.repo.impl.GradRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("grad")
@RequiredArgsConstructor
@CrossOrigin
public class GradController {
    private final GradRepo gradRepo;

    @GetMapping
    public List<Grad> getAll() {
        return gradRepo.findAll();
    }

    @PostMapping
    public void addGrad(@RequestBody Grad grad) {
        gradRepo.save(grad);
    }

    @DeleteMapping
    public void deleteGrad(@RequestParam Long id) {
        gradRepo.deleteById(id);
    }

    @PutMapping
    public void updateGrad(@RequestParam Long oldId, @RequestBody Grad newGrad) {
        gradRepo.update(oldId, newGrad);
    }
}
