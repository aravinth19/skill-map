package com.skillmap.controller;

import com.skillmap.dto.RoleDTO;
import com.skillmap.entity.Role;
import com.skillmap.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:3000")  // ✅ Allow React requests
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public Role addRole(@RequestBody RoleDTO roleDTO) {
        return roleService.addRole(roleDTO);
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/by-profession")  // ✅ This now has a unique path
    public List<Role> getRolesByProfession(@RequestParam Long professionId) {
        return roleService.getRolesByProfession(professionId);
    }
}