package com.springboot.aes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableJpaRepositories(basePackages = "com.springboot.aes.repository")
//@ComponentScan(basePackages = {"com.example.DemoApplication"})
public class AesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AesApplication.class, args);
	}

}
