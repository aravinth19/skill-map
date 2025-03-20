package com.skillmap.service;

import com.skillmap.dto.RoleDTO;
import com.skillmap.entity.Profession;
import com.skillmap.entity.Role;
import com.skillmap.repository.ProfessionRepository;
import com.skillmap.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final ProfessionRepository professionRepository;

    public RoleService(RoleRepository roleRepository, ProfessionRepository professionRepository) {
        this.roleRepository = roleRepository;
        this.professionRepository = professionRepository;
    }

    public Role addRole(RoleDTO roleDTO) {
        if (roleDTO.getProfessionId() == null) {
            throw new IllegalArgumentException("Profession ID cannot be null");
        }

        Profession profession = professionRepository.findById(roleDTO.getProfessionId())
                .orElseThrow(() -> new RuntimeException("Profession not found with ID: " + roleDTO.getProfessionId()));

        Role role = new Role();
        role.setName(roleDTO.getName());
        role.setProfession(profession);

        return roleRepository.save(role);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public List<Role> getRolesByProfession(Long professionId) {
        return roleRepository.findByProfessionId(professionId);
    }
}
