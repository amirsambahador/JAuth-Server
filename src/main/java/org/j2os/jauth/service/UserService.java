package org.j2os.jauth.service;

import org.j2os.jauth.common.security.SHA;
import org.j2os.jauth.entity.Role;
import org.j2os.jauth.entity.User;
import org.j2os.jauth.exception.*;
import org.j2os.jauth.repository.RoleDA;
import org.j2os.jauth.repository.UserDA;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {
    private final UserDA userDA;
    private final RoleDA roleDA;

    public UserService(UserDA userDA, RoleDA roleDA) {
        this.userDA = userDA;
        this.roleDA = roleDA;
    }

    @Transactional
    public UserService save(User user) throws NoSuchAlgorithmException {
        user.setCreationTime(System.currentTimeMillis());
        user.setPassword(SHA.get512(user.getPassword().concat(user.getCreationTime().toString())));
        userDA.save(user);
        return this;
    }


    @Transactional
    public UserService remove(User user) {
        userDA.delete(user);
        return this;
    }

    @Transactional
    public UserService addRole(User user, Role role) throws UserNotFindException, RoleNotFindException {
        User dbUser = userDA.findById(user.getUserId()).orElseThrow(UserNotFindException::new);
        Role dbRole = roleDA.findById(role.getRoleId()).orElseThrow(RoleNotFindException::new);
        dbUser.getRoles().add(dbRole);
        userDA.save(dbUser);
        return this;
    }

    public String login(User user) throws InvalidUsernameAndPasswordException, UserNotFindException, NoSuchAlgorithmException, JAuthTokenInvalid {
        user = userDA.findByUsernameAndPassword(user.getUsername(), SHA.get512(user.getPassword()
                .concat(findByUsername(user).getCreationTime().toString())))
                .orElseThrow(InvalidUsernameAndPasswordException::new);
        user.setToken(UUID.randomUUID().toString());
        userDA.save(user);
        return user.getToken();
    }

    public User findByToken(User user) throws InvalidTokenException {

        return userDA.findByToken(user.getToken()).orElseThrow(InvalidTokenException::new);
    }

    public Iterable<User> findAll() {

        return userDA.findAll();
    }

    public User findByUsername(User user) throws UserNotFindException {

        return userDA.findByUsername(user.getUsername()).orElseThrow(UserNotFindException::new);
    }

    public User findById(User user) throws UserNotFindException {

        return userDA.findById(user.getUserId()).orElseThrow(UserNotFindException::new);
    }

}
