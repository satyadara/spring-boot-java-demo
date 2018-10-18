package com.example.demospringboot.service.implementation;

import com.example.demospringboot.model.Role;
import com.example.demospringboot.repository.RoleRepository;
import com.example.demospringboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }
}
