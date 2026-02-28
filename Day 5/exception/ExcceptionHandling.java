package com.exception;
import java.util.HashMap;

// Custom exception
class UsernameExistsException extends Exception {
    public UsernameExistsException(String message) {
        super(message);
    }
}


class UserCredentials extends HashMap<String, String> {

    @Override
    public String put(String key, String value) {
        if (this.containsKey(key)) {
            throw new RuntimeException(
                new UsernameExistsException("Username already exists: " + key)
            );
        }
        return super.put(key, value);
    }
}

public class ExcceptionHandling {
    public static void main(String[] args) {

        UserCredentials users = new UserCredentials();

        try {
            users.put("john", "1234");
            users.put("alex", "5678");
            users.put("john", "9999"); // Duplicate username
        } catch (RuntimeException e) {
            System.out.println(e.getCause().getMessage());
        }
    }
}