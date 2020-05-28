package com.theatre.service.interfaces;

import com.theatre.model.Admin;

import java.util.Optional;

public interface AdminService {
    Optional<Admin> login(String username, String password);
}
