package com.homelab.romrominitializr;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String login;
    private String password;
    private Date registrationDate;

    @OneToOne
    @JoinColumn(name="user_info")
    private UserInformation userInformation;


    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="users_skills", joinColumns={@JoinColumn(referencedColumnName="id")}
            , inverseJoinColumns={@JoinColumn(referencedColumnName="id")})
    private Set<Skill> skills = new HashSet<>();

    public User() {
        super();
    }

    public User(String login, String password, Date registrationDate) {
        this.login = login;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }
    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkill(Skill newSkill) {
        skills.add(newSkill);
        newSkill.addOwner(this);
    }

    public void setSkills(List<Skill> newSkills){
        skills.addAll(newSkills.stream().peek(skill -> skill.addOwner(this)).collect(Collectors.toSet()));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
