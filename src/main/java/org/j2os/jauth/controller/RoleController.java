package org.j2os.jauth.controller;

import org.j2os.jauth.common.wrapper.ExceptionWrapper;
import org.j2os.jauth.entity.Role;
import org.j2os.jauth.service.RoleService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    private final RoleService roleService;


    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping("/save")
    public Object save(@ModelAttribute Role role) {
        try {
            return roleService.save(role).findById(role);
        } catch (Exception e) {
            return ExceptionWrapper.getError(e);
        }
    }


    @RequestMapping("/remove")
    public Object remove(@ModelAttribute Role role) {
        try {
            return roleService.remove(role).findAll();
        } catch (Exception e) {
            return ExceptionWrapper.getError(e);
        }
    }

    @RequestMapping("/findAll")
    public Object findAll() {
        try {
            return roleService.findAll();
        } catch (Exception e) {
            return ExceptionWrapper.getError(e);
        }
    }


    @RequestMapping("/findByRoleName")
    public Object findByRoleName(@ModelAttribute Role role) {
        try {
            return roleService.findByRoleName(role);
        } catch (Exception e) {
            return ExceptionWrapper.getError(e);
        }
    }


}
