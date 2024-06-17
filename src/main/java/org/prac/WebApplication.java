package org.prac;

import lombok.extern.log4j.Log4j2;
import org.prac.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Log4j2
@Component
public class WebApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args){
        SpringApplication springApplication =  new SpringApplication(WebApplication.class);
        springApplication.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        UserRepository userRepository = applicationContext.getBean(UserRepository.class);
        userRepository.findAll().forEach(user -> log.debug(user.toString()));
    }
}
