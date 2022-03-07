package com.bitnet.paulo.SpringBootDemo.beans;

import com.bitnet.paulo.SpringBootDemo.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MainBeanContainer {

    @Bean(name = "admin")
    public User getAdministratorUser() {
        return new User("Admin", "ADMIN");
    }
}
