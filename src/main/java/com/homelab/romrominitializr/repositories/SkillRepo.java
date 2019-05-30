package com.homelab.romrominitializr.repositories;

import com.homelab.romrominitializr.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepo extends JpaRepository<Skill, Integer> {
}
