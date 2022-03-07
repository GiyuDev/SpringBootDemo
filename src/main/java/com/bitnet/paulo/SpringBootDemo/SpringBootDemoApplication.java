package com.bitnet.paulo.SpringBootDemo;

import com.bitnet.paulo.SpringBootDemo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(path = "main")
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@GetMapping(path = "hello")
	public String hello() {
		return "Hello world";
	}

	@Autowired
	@Qualifier("admin")
	private User admin;

	@GetMapping(path = "admin")
	public String getAdminUser() {
		return admin.toString();
	}
}
