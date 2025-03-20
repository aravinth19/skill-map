package com.skillmap.service;

import com.skillmap.dto.SkillDTO;
import com.skillmap.entity.Role;
import com.skillmap.entity.Skill;
import com.skillmap.repository.RoleRepository;
import com.skillmap.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private final SkillRepository skillRepository;
    private final RoleRepository roleRepository;

    public SkillService(SkillRepository skillRepository, RoleRepository roleRepository) {
        this.skillRepository = skillRepository;
        this.roleRepository = roleRepository;
    }

    public Skill addSkill(SkillDTO skillDTO) {
        if (skillDTO.getRoleId() == null) {
            throw new IllegalArgumentException("Role ID cannot be null");
        }

        Role role = roleRepository.findById(skillDTO.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found with ID: " + skillDTO.getRoleId()));

        Skill skill = new Skill();
        skill.setName(skillDTO.getName());
        skill.setRole(role);

        return skillRepository.save(skill);
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public List<Skill> getSkillsByRole(Long roleId) {
        return skillRepository.findByRoleId(roleId);
    }
}
