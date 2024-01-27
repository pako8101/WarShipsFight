package com.example.warshipsfight.repositories;

import com.example.warshipsfight.models.User;
import com.example.warshipsfight.models.dtos.LoginDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);



    Optional<User> findByUsernameAndPassword(String username, String password1);

}
