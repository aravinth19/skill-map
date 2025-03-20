package com.skillmap.service;

import com.skillmap.entity.Profession;
import com.skillmap.repository.ProfessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionService {

    private final ProfessionRepository professionRepository;

    public ProfessionService(ProfessionRepository professionRepository) {
        this.professionRepository = professionRepository;
    }

    public Profession addProfession(Profession profession) {
        return professionRepository.save(profession);
    }

    public List<Profession> getAllProfessions() {
        return professionRepository.findAll();
    }
}
