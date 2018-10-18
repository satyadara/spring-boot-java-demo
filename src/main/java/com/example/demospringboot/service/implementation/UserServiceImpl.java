package com.example.demospringboot.service.implementation;

import com.example.demospringboot.model.User;
import com.example.demospringboot.repository.RoleRepository;
import com.example.demospringboot.repository.UserRepository;
import com.example.demospringboot.request.UserRequest;
import com.example.demospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<User> index(String key) {
        return userRepository.findAllByNameContaining(key);
    }

    @Override
    public User get(String id) {
        return userRepository.getOne(id);
    }

    @Override
    public User save(UserRequest request) {
        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .name(request.getName())
                .address(request.getAddress())
                .role(roleRepository.getOne(request.getRole()))
                .build();

        return userRepository.save(user);
    }

    @Override
    public User update(UserRequest request, String id) {
        User user = userRepository.getOne(id);
        user.setName(request.getName());
        user.setAddress(request.getAddress());
        user.setRole(roleRepository.getOne(request.getRole()));

        return userRepository.save(user);
    }

    @Override
    public String delete(String id) {
        return userRepository.getOne(id) == null ? "USER TIDAK ADA" : id + "BERHASIL DI HAPUS";
    }
}
