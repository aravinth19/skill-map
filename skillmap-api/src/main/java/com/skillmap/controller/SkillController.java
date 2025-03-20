package com.skillmap.controller;

import com.skillmap.dto.SkillDTO;
import com.skillmap.entity.Skill;
import com.skillmap.service.SkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "http://localhost:3000")  // ✅ Allow React requests
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public Skill addSkill(@RequestBody SkillDTO skillDTO) {
        return skillService.addSkill(skillDTO);
    }

    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }

    @GetMapping("/by-role")  // ✅ This now has a unique path
    public List<Skill> getSkillsByRole(@RequestParam Long roleId) {
        return skillService.getSkillsByRole(roleId);
    }
}