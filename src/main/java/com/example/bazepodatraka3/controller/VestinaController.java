package com.example.bazepodatraka3.controller;

import com.example.bazepodatraka3.model.Vestina;
import com.example.bazepodatraka3.repo.impl.VestinaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vestina")
@RequiredArgsConstructor
@CrossOrigin
public class VestinaController {
    private final VestinaRepo vestinaRepo;

    @GetMapping
    public List<Vestina> getAll() {
        return vestinaRepo.findAll();
    }

    @PostMapping
    public void addVestina(@RequestBody Vestina vestina) {
        vestinaRepo.save(vestina);
    }

    @DeleteMapping
    public void deleteVestina(@RequestParam Long id) {
        vestinaRepo.deleteById(id);
    }

    @PutMapping
    public void updateVestina(@RequestParam Long oldId, @RequestBody Vestina newVestina) {
        vestinaRepo.update(oldId, newVestina);
    }
}
