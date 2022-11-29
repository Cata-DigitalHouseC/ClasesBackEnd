package com.dh.spring.animal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //Controladores son los primeros en recibir las peticiones d ela web en una arq API
public class Clase21SpringApplication {

	public static void main(String[] args) {SpringApplication.run(Clase21SpringApplication.class, args);}

	@GetMapping("/")
	public String saludar() {
		System.out.println("Como estas?");
		return "Hola mundo";
	}


}
