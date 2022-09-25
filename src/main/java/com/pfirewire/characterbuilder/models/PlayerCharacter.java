package com.pfirewire.characterbuilder.models;

import java.util.List;

public class PlayerCharacter {

    private String name;
    private int level;
    private Race race;
    private CharacterClass charClass;
    private List<AbilityScore> abilityScores;
    private List<Spell> spells;

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