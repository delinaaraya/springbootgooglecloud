package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class Cst339MilestoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cst339MilestoneApplication.class, args);
	}

}
