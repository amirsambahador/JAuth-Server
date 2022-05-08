package org.j2os.project.repository;

import org.j2os.project.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDA extends CrudRepository<Role, Long> {
    Optional<Role> findByRoleName(String name);


}
