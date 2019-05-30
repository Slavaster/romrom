package com.homelab.romrominitializr.security;

import com.homelab.romrominitializr.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByLogin(String login);
}
