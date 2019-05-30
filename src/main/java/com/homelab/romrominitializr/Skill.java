package com.homelab.romrominitializr;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "skills", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")})
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(mappedBy = "skills", cascade = CascadeType.ALL)
    private Set<User> owners = new HashSet<>();
    @Enumerated(EnumType.STRING)
    private SkillLevel skillLevel;
    private String name;

    public Set<User> getOwners() {
        return owners;
    }

    public void addOwner(User newOwner){
        owners.add(newOwner);
        if(!newOwner.getSkills().contains(this)) newOwner.setSkill(this);
    }

    public Skill() {
        super();
    }

    public Skill(String name, SkillLevel skillLevel) {
        this.name = name;
        this.skillLevel = skillLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    @Override
    public String toString() {
        return name + " (" + skillLevel.toString() + ")";
    }
}
