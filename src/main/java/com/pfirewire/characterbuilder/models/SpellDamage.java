package com.pfirewire.characterbuilder.models;

import javax.persistence.*;


public class SpellDamage {

    private String damageType;

    public SpellDamage() {}

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }
//    private DamageAtSlotLevel damageAtSlotLevel;
}
