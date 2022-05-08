package org.j2os.project.service;

import org.j2os.project.entity.Role;
import org.j2os.project.exception.RoleNotFindException;
import org.j2os.project.repository.RoleDA;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {
    private final RoleDA roleDA;

    public RoleService(RoleDA roleDA) {
        this.roleDA = roleDA;
    }

    @Transactional
    public RoleService save(Role role) {
        roleDA.save(role);
        return this;
    }

    @Transactional
    public RoleService remove(Role role) {
        roleDA.delete(role);
        return this;
    }

    public Iterable<Role> findAll() {
        return roleDA.findAll();
    }

    public Role findById(Role role) throws RoleNotFindException {
        return roleDA.findById(role.getRoleId()).orElseThrow(RoleNotFindException::new);
    }

    public Role findByRoleName(Role role) throws RoleNotFindException {
        return roleDA.findByRoleName(role.getRoleName()).orElseThrow(RoleNotFindException::new);
    }

}
