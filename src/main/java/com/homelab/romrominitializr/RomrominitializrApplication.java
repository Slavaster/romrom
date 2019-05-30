package com.homelab.romrominitializr;

import com.homelab.romrominitializr.repositories.SkillRepo;
import com.homelab.romrominitializr.repositories.UserInfoRepo;
import com.homelab.romrominitializr.repositories.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class RomrominitializrApplication {

	public static void main(String[] args) {
		SpringApplication.run(RomrominitializrApplication.class, args);
	}

	@Bean
	public String runTest(UserRepo userRepo, SkillRepo skillRepo, UserInfoRepo userInfoRepo) {






		Skill skill_hibernate = new Skill("Hibernate", SkillLevel.BEGINNER);
		Skill skill_spring_mvc = new Skill("Spring MVC", SkillLevel.EXPERIENCED);
		Skill skill_java = new Skill("Java", SkillLevel.BEGINNER);
		Skill skill_python = new Skill("Python", SkillLevel.EXPERIENCED);
		Skill skill_mysql = new Skill("MySQL", SkillLevel.PROFESSIONAL);
		Skill skill_linux = new Skill("Linux", SkillLevel.BEGINNER);
		Skill skill_networks = new Skill("Networks", SkillLevel.EXPERIENCED);
		Skill skill_communication = new Skill("Communication", SkillLevel.PROFESSIONAL);

		UserInformation ui_1 = new UserInformation("Petro", "Bamper", "0637362514", "petiabamper@gmail.com", "Kyiv", new Date(1993-1900, 12-1, 17));
		UserInformation ui_2 = new UserInformation("Korben", "Dalas", "0673283746", "korbendalas@gmail.com", "New York", new Date(1986-1900, 2-1, 2));
		UserInformation ui_3 = new UserInformation("John", "Week", "0501029387", "rembo@gmail.com", "London", new Date(1971-1900, 9-1, 26));
		UserInformation ui_4 = new UserInformation("Vasia", "Gopnik", "0631872945", "gopnik@gmail.com", "Kyiv", new Date(2000-1900, 4-1, 24));

		User user1 = new User("Gopnik", BCrypt.hashpw("1111", BCrypt.gensalt(10)), new Date(2019-1900, 5-1, 14));
		user1.setSkills(Arrays.asList(skill_hibernate, skill_spring_mvc));
		user1.setUserInformation(ui_1);

		User user2 = new User("Petro", BCrypt.hashpw("1111", BCrypt.gensalt(10)), new Date(2019-1900, 5-1, 10));
		user2.setSkills(Arrays.asList(skill_java, skill_linux, skill_mysql));
		user2.setUserInformation(ui_2);

		User user3 = new User("Korben",BCrypt.hashpw("1111", BCrypt.gensalt(10)), new Date(2019-1900, 5-1, 4));
		user3.setSkills(Arrays.asList(skill_linux, skill_communication));
		user3.setUserInformation(ui_3);

		User user4 = new User("John",BCrypt.hashpw("1111", BCrypt.gensalt(10)) , new Date(2019-1900, 5-1, 20));
		user4.setSkills(Arrays.asList(skill_python, skill_networks));
		user4.setUserInformation(ui_4);


		skillRepo.save(skill_hibernate);
		skillRepo.save(skill_spring_mvc);
		skillRepo.save(skill_java);
		skillRepo.save(skill_python);
		skillRepo.save(skill_mysql);
		skillRepo.save(skill_linux);
		skillRepo.save(skill_networks);
		skillRepo.save(skill_communication);

		userInfoRepo.save(ui_1);
		userInfoRepo.save(ui_2);
		userInfoRepo.save(ui_3);
		userInfoRepo.save(ui_4);

		userRepo.save(user1);
		userRepo.save(user2);
		userRepo.save(user3);
		userRepo.save(user4);




		return "---- SAVED -----";
	}



}
