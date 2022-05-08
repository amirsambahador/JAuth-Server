package org.j2os.project.controller;

import org.j2os.project.common.wrapper.ExceptionWrapper;
import org.j2os.project.entity.Role;
import org.j2os.project.entity.User;
import org.j2os.project.service.UserService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/save")
    public Object save(@ModelAttribute User user) {
        try {
            return userService.save(user).findById(user);
        } catch (Exception e) {
            return ExceptionWrapper.getError(e);
        }
    }

    @RequestMapping("/update")
    public Object update(@ModelAttribute User user) {
        try {
            return userService.update(user).findById(user);
        } catch (Exception e) {
            return ExceptionWrapper.getError(e);
        }
    }

    @RequestMapping("/remove")
    public Object remove(@ModelAttribute User user) {
        try {
            return userService.remove(user).findAll();
        } catch (Exception e) {
            return ExceptionWrapper.getError(e);
        }
    }

    @RequestMapping("/addRole")
    public Object addRole(@ModelAttribute User user, @ModelAttribute Role role) {
        try {
            return userService.addRole(user, role).findById(user);
        } catch (Exception e) {
            return ExceptionWrapper.getError(e);
        }
    }

    @RequestMapping("/findAll")
    public Object findAll() {
        try {
            return userService.findAll();
        } catch (Exception e) {
            return ExceptionWrapper.getError(e);
        }
    }

    @RequestMapping("/login")
    public Object login(@ModelAttribute User user) {
        try {
            return userService.login(user);
        } catch (Exception e) {
            return ExceptionWrapper.getError(e);
        }
    }

    @RequestMapping("/findByToken")
    public Object findByToken(@ModelAttribute User user) {
        try {
            return userService.findByToken(user);
        } catch (Exception e) {
            return ExceptionWrapper.getError(e);
        }
    }

    @RequestMapping("/findByUsername")
    public Object findByUsername(@ModelAttribute User user) {
        try {
            return userService.findByUsername(user);
        } catch (Exception e) {
            return ExceptionWrapper.getError(e);
        }
    }

    @RequestMapping("/findById")
    public Object findById(@ModelAttribute User user) {
        try {
            return userService.findById(user);
        } catch (Exception e) {
            return ExceptionWrapper.getError(e);
        }
    }
}
