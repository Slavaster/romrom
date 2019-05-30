package com.homelab.romrominitializr.repositories;

import com.homelab.romrominitializr.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface UserInfoRepo extends JpaRepository<UserInformation, CriteriaBuilder.In> {
}
