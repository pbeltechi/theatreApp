package com.theatre.service;

import com.theatre.model.Admin;
import com.theatre.repository.AdminRepository;
import com.theatre.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Optional<Admin> login(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username,password);
    }
}
