package com.homelab.romrominitializr.playaround_hibernate_db;

import com.homelab.romrominitializr.Skill;
import com.homelab.romrominitializr.SkillLevel;
import com.homelab.romrominitializr.User;
import com.homelab.romrominitializr.UserInformation;
import org.hibernate.Session;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) {


        fillInDB();

        getFromDB();



    }


    private static void getFromDB(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User user = session.get(User.class, 12);

        HibernateUtil.getSessionFactory().close();
    }
    @Bean
    private static void fillInDB(){
        Skill skill_java = new Skill("Java", SkillLevel.BEGINNER);
        Skill skill_python = new Skill("Python", SkillLevel.EXPERIENCED);
        Skill skill_mysql = new Skill("MySQL", SkillLevel.PROFESSIONAL);
        Skill skill_linux = new Skill("Linux", SkillLevel.BEGINNER);
        Skill skill_networks = new Skill("Networks", SkillLevel.EXPERIENCED);
        Skill skill_communication = new Skill("Communication", SkillLevel.PROFESSIONAL);

        UserInformation ui_1 = new UserInformation("Petro", "Bamper", "0637362514", "petiabamper@gmail.com", "Kyiv", new Date(1993-1900, 12-1, 17));
        UserInformation ui_2 = new UserInformation("Korben", "Dalas", "0673283746", "korbendalas@gmail.com", "New York", new Date(1986-1900, 2-1, 2));
        UserInformation ui_3 = new UserInformation("John", "Week", "0501029387", "rembo@gmail.com", "London", new Date(1971-1900, 9-1, 26));

        User user1 = new User("Petro","Start123", null);
        user1.setSkills(Arrays.asList(skill_java, skill_linux, skill_mysql));
        user1.setUserInformation(ui_1);

        User user2 = new User("Korben","Start123", null);
        user2.setSkills(Arrays.asList(skill_linux, skill_communication));
        user2.setUserInformation(ui_2);

        User user3 = new User("John","Start123", null);
        user3.setSkills(Arrays.asList(skill_python, skill_networks));
        user3.setUserInformation(ui_3);





//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        //saving skills
//        session.saveOrUpdate(skill_java);
//        session.saveOrUpdate(skill_python);
//        session.saveOrUpdate(skill_mysql);
//        session.saveOrUpdate(skill_linux);
//        session.saveOrUpdate(skill_networks);
//        session.saveOrUpdate(skill_communication);
//        //saving info
//        session.saveOrUpdate(ui_1);
//        session.saveOrUpdate(ui_2);
//        session.saveOrUpdate(ui_3);
//        //saving users
//        session.saveOrUpdate(user1);
//        session.saveOrUpdate(user2);
//        session.saveOrUpdate(user3);
//
//        session.getTransaction().commit();
//        HibernateUtil.shutdown();
    }
}
