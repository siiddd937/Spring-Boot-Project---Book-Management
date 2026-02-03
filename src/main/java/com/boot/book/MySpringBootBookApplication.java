package com.boot.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //to enable timestamp in author entity
public class MySpringBootBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootBookApplication.class, args);
	}

}
