package com.j2kb5th.chippo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ChippoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChippoApplication.class, args);
	}

}
