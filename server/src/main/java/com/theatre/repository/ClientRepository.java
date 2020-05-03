package com.theatre.repository;

import com.theatre.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    public Optional<Client> findByFirstNameAndLastName(String firstName, String lastName);
}
