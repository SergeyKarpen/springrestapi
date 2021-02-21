package com.karpen.springRestApi.rest;

import com.karpen.springRestApi.model.User;
import com.karpen.springRestApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/karpen/api/")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping(value = "/users")
    @PreAuthorize("hasAnyAuthority('admin', 'moderator')")
    public String findAll() {
        List<User> users = userService.findAll();
        return users.toString();
    }

    @ResponseBody
    @GetMapping(value = "/user/{id}")
    @PreAuthorize("hasAnyAuthority('admin', 'moderator')")
    public String findById(@PathVariable("id") Long id) {
        return userService.findById(id).toString();
    }

    @ResponseBody
    @DeleteMapping(value = "/user-deleted/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public String deletedById (@PathVariable("id") Long id) {
        userService.deletedById(id);
        return "deleted user with id = " + id;
    }

    @ResponseBody
    @PostMapping(value = "/user-save")
    @PreAuthorize("hasAuthority('admin')")
    public String save (@RequestBody User user) {
        userService.save(user);
        return "save user with id = " + user.getId();
    }
}
