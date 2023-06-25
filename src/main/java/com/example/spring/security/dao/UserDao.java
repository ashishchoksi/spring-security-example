package com.example.spring.security.dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDao {
    private final List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User("ashish@gmail.com", "123456",
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))),
            new User("piyush@gmail.com", "password1",
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")))
    );

    public UserDetails findUserByEmail(String email) {
        return APPLICATION_USERS.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No User Found with email: " + email));
    }
}
