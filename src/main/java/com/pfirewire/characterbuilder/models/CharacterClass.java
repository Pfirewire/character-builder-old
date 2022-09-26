package com.pfirewire.characterbuilder.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classes")
public class CharacterClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "hitdie_id")
    private HitDie hitDie;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "classes_proficiencies",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "proficiency_id")}
    )
    private List<Proficiency> proficiencies;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "classes_saving_throws",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "saving_throw_id")}
    )
    private List<AbilityScore> savingThrows;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "classes_spells",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "spell_id")}
    )
    private List<Spell> spellList;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "classes_starting_equipment_list",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "equipment_id")}
    )
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
