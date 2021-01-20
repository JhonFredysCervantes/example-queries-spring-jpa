package com.unimag.queries;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.unimag.queries.entity.Persona;
import com.unimag.queries.repository.PersonaRepository;

@SpringBootApplication
public class QueriesApplication {
	
	@Autowired
	PersonaRepository rp;

	public static void main(String[] args) {
		SpringApplication.run(QueriesApplication.class, args);
	}
	
	/*@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			
			Persona camilo = new Persona();
			camilo.setNumeroIdentificacion("123");
			camilo.setPrimerNombre("Camilo");
			camilo.setPrimerApellido("Lopez");
			camilo.setNacimiento(new Date());
			
			rp.save(camilo);
			
			System.out.println(rp.buscarNoFallecidos());
			System.out.println(rp.findByFallecimientoIsNull());
			
			System.out.println(rp.buscarPorIdentificacion("123"));
			System.out.println(rp.findByNumeroIdentificacion("123"));
			
			System.out.println(rp.buscarPorPatronPrimerNombre("Cam"));
			System.out.println(rp.findByPrimerNombreLike("Camilo"));
			

		};
	}
	*/

}
