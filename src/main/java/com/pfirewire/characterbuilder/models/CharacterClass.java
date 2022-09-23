package com.pfirewire.characterbuilder.models;

import java.util.List;

public class CharacterClass {

    private String name;
    private HitDie hitDie;
    private List<Proficiency> proficiencies;
    private List<AbilityScore> savingThrows;
    private List<Equipment> startingEquipment;


    public CharacterClass() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HitDie getHitDie() {
        return hitDie;
    }

    public void setHitDie(HitDie hitDie) {
        this.hitDie = hitDie;
    }

    public List<Proficiency> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(List<Proficiency> proficiencies) {
        this.proficiencies = proficiencies;
    }

    public List<AbilityScore> getSavingThrows() {
        return savingThrows;
    }

    public void setSavingThrows(List<AbilityScore> savingThrows) {
        this.savingThrows = savingThrows;
    }

    public List<Equipment> getStartingEquipment() {
        return startingEquipment;
    }

    public void setStartingEquipment(List<Equipment> startingEquipment) {
        this.startingEquipment = startingEquipment;
    }
}
