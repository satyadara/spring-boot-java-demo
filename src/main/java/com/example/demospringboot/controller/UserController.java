package com.example.demospringboot.controller;

import com.example.demospringboot.model.Role;
import com.example.demospringboot.model.User;
import com.example.demospringboot.request.UserRequest;
import com.example.demospringboot.service.RoleService;
import com.example.demospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/roles",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Role> getAllRole() {
        return roleService.getAllRole();
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> index(@Param("key") String key) {
        return userService.index(key);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("id") String id) {
        return userService.get(id);
    }

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User save(@RequestBody UserRequest request) {
        return userService.save(request);
    }


    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User update(@RequestBody UserRequest request, @PathVariable("id") String id) {
        return userService.update(request, id);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@PathVariable("id") String id) {
        return userService.delete(id);
    }
}
