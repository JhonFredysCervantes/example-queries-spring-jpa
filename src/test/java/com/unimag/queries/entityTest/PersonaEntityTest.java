package com.unimag.queries.entityTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.unimag.queries.entity.Persona;


public class PersonaEntityTest {
	
	private Persona oscar, oscarCopy, juan;
	
	@Before
	public void inicializarPersonas() {
		oscar = new Persona("123","Oscar","Roltik",'M',new Date(2000,4,23),null);
		oscarCopy = new Persona("123","Oscar","Roltik",'M',new Date(2000,4,23),null);
		juan = new Persona("456","Juan","Roltik",'M',new Date(2000,4,23),null);
	}
	
	@Test
	public void setersAndGettersPersonaTest() {
		Long idPersona = 4L;
		String numeroIdentificacion = "777", primerNombre = "Andres", segundoNombre = "Camilo", primerApellido = "Moya",
				segundoApellido = "Lopez";
		String error = "Error en el seteo u obtencion en objeto Persona el atributo ";
		char genero = 'M';
		Date nacimiento = new Date(1930,11,11);
		Date fallecimiento = new Date(2020, 4,8);
		
		juan.setIdPersona(idPersona);
		juan.setNumeroIdentificacion(numeroIdentificacion);
		juan.setPrimerNombre(primerNombre);
		juan.setSegundoNombre(segundoNombre);
		juan.setPrimerApellido(primerApellido);
		juan.setSegundoApellido(segundoApellido);
		juan.setGenero(genero);
		juan.setNacimiento(nacimiento);
		juan.setFallecimiento(fallecimiento);
		
		assertEquals(error+"idPersona", idPersona, juan.getIdPersona());
		assertEquals(error+"identificacion", numeroIdentificacion, juan.getNumeroIdentificacion());
		assertEquals(error+"primerNombre", primerNombre, juan.getPrimerNombre());
		assertEquals(error+"segundoNombre", segundoNombre, juan.getSegundoNombre());
		assertEquals(error+"primerApellido", primerApellido, juan.getPrimerApellido());
		assertEquals(error+"segundoApellido", segundoApellido, juan.getSegundoApellido());
		assertEquals(error+"genero", genero, juan.getGenero());
		assertEquals(error+"nacimiento", nacimiento, juan.getNacimiento());
		assertEquals(error+"fallecimiento", fallecimiento, juan.getFallecimiento());
		
	}
	
	@Test
	public void EqualsPersonasTest() {
		assertTrue(oscar.equals(oscarCopy)); //Tambien se puede usar: assertEquals(oscar, oscarCopy);
	}
	
	@Test
	public void NoEqualsPersonasTest() {
		assertFalse(oscar.equals(juan));
	}

}
