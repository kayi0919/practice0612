package org.prac.web.service;

import lombok.extern.log4j.Log4j2;
import org.prac.web.entity.SessionData;
import org.prac.database.entity.User;
import org.prac.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Log4j2
public class UserDetailsServiceImpl implements UserDetailsService {

    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository usersRepository;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("username: {}", username);
        User users = usersRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        log.debug("users: {}" , users);
        SessionData sessionData = new SessionData();
        sessionData.setUsername(users.getUsername());

        sessionData.setPassword(passwordEncoder.encode(users.getPassword()));
        return sessionData;
    }
}
