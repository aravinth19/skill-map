package com.skillmap.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Profession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false ,unique = true)
    private String name;

    @OneToMany(mappedBy = "profession" , cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Role> roles;

}
