package org.j2os.project.common.wrapper;

import org.j2os.project.exception.*;
import org.springframework.dao.DataIntegrityViolationException;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class ExceptionWrapper {
    private ExceptionWrapper() {
    }

    public static Map<String, String> getError(Exception e) {
        e.printStackTrace();
        Map<String, String> error = new HashMap<>();
        if (e instanceof ClassNotFoundException) {
            error.put("code", "101");
            error.put("message", "dependency lost");
            return error;
        } else if (e instanceof SQLException) {
            error.put("code", "102");
            error.put("message", "database error");
            return error;
        } else if (e instanceof InvalidTokenException) {
            error.put("code", "103");
            error.put("message", "client token error");
            return error;
        } else if (e instanceof InvalidUsernameAndPasswordException) {
            error.put("code", "104");
            error.put("message", "invalid username or password");
            return error;
        } else if (e instanceof JAuthTokenInvalid) {
            error.put("code", "105");
            error.put("message", "server token error");
            return error;
        } else if (e instanceof UserNotFindException) {
            error.put("code", "106");
            error.put("message", "username not exist error");
            return error;
        } else if (e instanceof RoleNotFindException) {
            error.put("code", "108");
            error.put("message", "role not exist error");
            return error;
        } else if (e instanceof DataIntegrityViolationException) {
            error.put("code", "107");
            error.put("message", "database constraint error");
            return error;
        } else {
            error.put("code", "200");
            error.put("message", "unknown");
            return error;
        }
    }
}
