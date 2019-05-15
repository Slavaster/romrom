package com.homelab.romrominitializr;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "skills", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")})
public class Skill {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    @ManyToMany
    private Set<User> owners = new HashSet<>();

    private String name;
    @Enumerated(EnumType.STRING)
    private SkillLevel skillLevel;

    @ManyToMany(mappedBy = "skills")
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

}
