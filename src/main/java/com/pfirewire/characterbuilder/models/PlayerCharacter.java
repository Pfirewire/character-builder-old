package com.pfirewire.characterbuilder.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "characters")
public class PlayerCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;
    @NotBlank
    @Column(nullable = false)
    private int level;
    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private CharacterClass charClass;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "characters_ability_scores",
            joinColumns = {@JoinColumn(name = "character_id")},
            inverseJoinColumns = {@JoinColumn(name = "ability_score_id")}
    )
    private List<AbilityScore> abilityScores;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "characters_spells",
            joinColumns = {@JoinColumn(name = "character_id")},
            inverseJoinColumns = {@JoinColumn(name = "spell_id")}
    )
    private List<Spell> spells;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors

    public PlayerCharacter() {}

    public PlayerCharacter(String name, int level, Race race, CharacterClass charClass) {
        this.name = name;
        this.level = level;
        this.race = race;
        this.charClass = charClass;
    }
    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public CharacterClass getCharClass() {
        return charClass;
    }

    public void setCharClass(CharacterClass charClass) {
        this.charClass = charClass;
    }

    public List<AbilityScore> getAbilityScores() {
        return abilityScores;
    }

    public void setAbilityScores(List<AbilityScore> abilityScores) {
        this.abilityScores = abilityScores;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void setSpells(List<Spell> spells) {
        this.spells = spells;
    }
}