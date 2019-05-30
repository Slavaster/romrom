package com.homelab.romrominitializr.repositories;

import com.homelab.romrominitializr.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    List<User> findByLoginAndPassword(String login, String password);
}
