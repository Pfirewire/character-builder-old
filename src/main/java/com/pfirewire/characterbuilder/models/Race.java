package com.pfirewire.characterbuilder.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "races")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String type;
    @Column(nullable = false)
    private int speed;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "race")
    private List<PlayerCharacter> characters;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "races_proficiencies",
            joinColumns = {@JoinColumn(name = "race_id")},
            inverseJoinColumns = {@JoinColumn(name = "proficiency_id")}
    )
    private List<Proficiency> proficiencies;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "races_ability_bonuses",
            joinColumns = {@JoinColumn(name = "race_id")},
            inverseJoinColumns = {@JoinColumn(name = "ability_bonus_id")}
    )
    private List<AbilityBonus> abilityBonuses;
    @Column(columnDefinition = "TEXT")
    private String alignment;
    @Column(columnDefinition = "TEXT")
    private String age;
    @Column
    private String size;
    @Column(columnDefinition = "TEXT")
    private String sizeDescription;

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

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSizeDescription() {
        return sizeDescription;
    }

    public void setSizeDescription(String sizeDescription) {
        this.sizeDescription = sizeDescription;
    }
}
