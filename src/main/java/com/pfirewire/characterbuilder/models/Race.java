package com.pfirewire.characterbuilder.models;

import java.util.List;

public class Race {

    private String type;
    private int speed;

    public Race() {}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public List<AbilityBonus> getAbilityBonuses() {
        return abilityBonuses;
    }

    public void setAbilityBonuses(List<AbilityBonus> abilityBonuses) {
        this.abilityBonuses = abilityBonuses;
    }

    private List<AbilityBonus> abilityBonuses;


}
