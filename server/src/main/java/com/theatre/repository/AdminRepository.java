package com.theatre.repository;

import com.theatre.model.Admin;
import com.theatre.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByUsernameAndPassword(String username, String password);
}
