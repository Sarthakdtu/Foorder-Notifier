package com.foordernotif.notifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class FoorderNotifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoorderNotifierApplication.class, args);
	}
}
