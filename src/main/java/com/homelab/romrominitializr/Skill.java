package com.homelab.romrominitializr;

import javax.persistence.*;

@Entity
@Table(name = "Skills")
public class Skill {

    @Id
    @GeneratedValue
    @Column(nullable=false)
    private int id;

    private String name;
    @Enumerated(EnumType.STRING)
    private SkillLevel skillLevel;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="Owner")
    private User owner;

    public User getUser() {
        return owner;
    }

    public void setUser(User user) {
        this.owner = user;
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
