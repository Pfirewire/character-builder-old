package com.pfirewire.characterbuilder.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ability_scores")
public class AbilityScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String fullName;
    @Column(nullable = false)
    private String quickDescription;
    @Column(nullable = false)
    private String longDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "abilityScore")
    private List<Skill> skills;
    @ManyToOne
    private AbilityBonus abilityBonus;


    public AbilityScore() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getQuickDescription() {
        return quickDescription;
    }

    public void setQuickDescription(String quickDescription) {
        this.quickDescription = quickDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public AbilityBonus getAbilityBonus() {
        return abilityBonus;
    }
    public void setAbilityBonus(AbilityBonus abilityBonus) {
        this.abilityBonus = abilityBonus;
    }
}
