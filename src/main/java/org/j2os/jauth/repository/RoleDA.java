package org.j2os.jauth.repository;

import org.j2os.jauth.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDA extends CrudRepository<Role, Long> {
    Optional<Role> findByRoleName(String name);


}
