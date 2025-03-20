package com.skillmap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "profession_id", nullable = false)
    @JsonIgnore  // ✅ Prevents infinite recursion
    private Profession profession;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Skill> skills;
}
