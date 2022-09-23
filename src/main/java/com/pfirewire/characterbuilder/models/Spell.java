package com.pfirewire.characterbuilder.models;

import java.util.List;

public class Spell {

    private String name;
    private int spellLevel;
    private String description;
    private String higherLevel;
    private int range;
    private List<String> components;
    private String material;
    private boolean isRitual;
    private String duration;
    private boolean isConcentration;
    private String castingTime;
    private String attackType;
    private SpellDamage damage;
    private String school;
    private List<CharacterClass> classes;

    public Spell() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpellLevel() {
        return spellLevel;
    }

    public void setSpellLevel(int spellLevel) {
        this.spellLevel = spellLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHigherLevel() {
        return higherLevel;
    }

    public void setHigherLevel(String higherLevel) {
        this.higherLevel = higherLevel;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public List<String> getComponents() {
        return components;
    }

    public void setComponents(List<String> components) {
        this.components = components;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isRitual() {
        return isRitual;
    }

    public void setRitual(boolean ritual) {
        isRitual = ritual;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isConcentration() {
        return isConcentration;
    }

    public void setConcentration(boolean concentration) {
        isConcentration = concentration;
    }

    public String getCastingTime() {
        return castingTime;
    }

    public void setCastingTime(String castingTime) {
        this.castingTime = castingTime;
    }

    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public SpellDamage getDamage() {
        return damage;
    }

    public void setDamage(SpellDamage damage) {
        this.damage = damage;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public List<CharacterClass> getClasses() {
        return classes;
    }

    public void setClasses(List<CharacterClass> classes) {
        this.classes = classes;
    }
}
