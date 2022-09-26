package com.pfirewire.characterbuilder.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hitdie")
public class HitDie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private int value;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hitdie")
    private List<CharacterClass> classes;

    public HitDie() {}

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
