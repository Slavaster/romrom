package com.homelab.romrominitializr.repositories;

import com.homelab.romrominitializr.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {

    List<User> findByLoginAndPassword(String login, String password);

}
