package cl.desafiolatam.contactmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"cl.desafiolatam.controller","beans","cl.desafiolatam.service","cl.desafiolatam.service.impl"})
public class ContactmanagerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ContactmanagerApplication.class, args);
	}

}
