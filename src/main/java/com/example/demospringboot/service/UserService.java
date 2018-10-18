package com.example.demospringboot.service;

import com.example.demospringboot.model.User;
import com.example.demospringboot.request.UserRequest;

import java.util.List;

public interface UserService {
    List<User> index(String key);
    User get(String id);
    User save(UserRequest request);
    User update(UserRequest request, String id);
    String delete(String id);
}
