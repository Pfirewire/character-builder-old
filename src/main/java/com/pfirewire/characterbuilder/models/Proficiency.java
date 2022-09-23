package com.pfirewire.characterbuilder.models;

import java.util.List;

public class Proficiency {

    private String name;
    private String type;
    private List<CharacterClass> classes;
    private List<Race> races;

    public Proficiency() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CharacterClass> getClasses() {
        return classes;
    }

    public void setClasses(List<CharacterClass> classes) {
        this.classes = classes;
    }

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }
}
