package org.j2os.project.controller;

import org.j2os.project.common.wrapper.ExceptionWrapper;
import org.j2os.project.entity.Role;
import org.j2os.project.service.RoleService;
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

    @RequestMapping("/findById")
    public Object findById(@ModelAttribute Role role) {
        try {
            return roleService.findById(role);
        } catch (Exception e) {
            return ExceptionWrapper.getError(e);
        }
    }
}
