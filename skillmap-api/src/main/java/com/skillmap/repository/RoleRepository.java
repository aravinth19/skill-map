package com.skillmap.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.skillmap.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByProfessionId(Long professionId);  // ✅ Fetch roles by profession ID
}