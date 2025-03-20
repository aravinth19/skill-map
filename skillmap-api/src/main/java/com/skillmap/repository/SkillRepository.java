package com.skillmap.repository;

import com.skillmap.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByRoleId(Long roleId);  // ✅ Fetch skills by role ID
}