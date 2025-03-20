package com.skillmap.controller;

import com.skillmap.entity.Profession;
import com.skillmap.service.ProfessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/professions")
public class ProfessionController {

    private final ProfessionService professionService;

    public ProfessionController(ProfessionService professionService) {
        this.professionService = professionService;
    }

    @PostMapping
    public Profession addProfession(@RequestBody Profession profession) {
        return professionService.addProfession(profession);
    }

    @GetMapping
    public List<Profession> getAllProfessions() {
        return professionService.getAllProfessions();
    }
}
