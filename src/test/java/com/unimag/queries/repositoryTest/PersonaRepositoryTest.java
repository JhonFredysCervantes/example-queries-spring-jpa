package com.unimag.queries.repositoryTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.unimag.queries.entity.Persona;
import com.unimag.queries.repository.PersonaRepository;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:test.properties")
@DataJpaTest
public class PersonaRepositoryTest {
	
	@Autowired
	private PersonaRepository rp;
	
	Persona oscar, juan, maria;
	
	@Before
	public void inicializarPersonas() {
		oscar = new Persona("123","Oscar","Lopez",'M',new Date(2000,4,12),null);
		juan = new Persona("456","Juan","Martinez",'M',new Date(1998,5,21),new Date(2020,11,15));
		maria = new Persona("789", "Maria", "Palmera",'F',new Date(2001,11,7), null);
		
		oscar = rp.save(oscar);
		juan = rp.save(juan);
		maria = rp.save(maria);
	}
	
	@Test
	public void buscarPersonaPorIdentificacionCasoVerdad() {
		assertEquals(rp.buscarPorIdentificacion(oscar.getNumeroIdentificacion()), 
				rp.findByNumeroIdentificacion(oscar.getNumeroIdentificacion()));
	}
	
	@Test
	public void buscarPersonaPorIdentificacionCasoFalso() {
		assertNotEquals(rp.buscarPorIdentificacion(oscar.getNumeroIdentificacion()), 
				rp.findByNumeroIdentificacion(juan.getNumeroIdentificacion()));
	}
	
	@Test
	public void buscarPorNombreYApellidoCasoVerdad() {
		assertEquals(rp.buscarPorNombreYApellido(oscar.getPrimerNombre(), oscar.getPrimerApellido()), 
				oscar);
	}
	
	@Test
	public void buscarPorNombreYApellidoCasoFalso() {
		assertNotEquals(rp.buscarPorNombreYApellido(oscar.getPrimerNombre(), oscar.getPrimerApellido()), 
				rp.buscarPorNombreYApellido(juan.getPrimerNombre(), juan.getPrimerApellido()));
	}
	
	@Test
	public void buscarNoFallecidos() {
		//oscar y maria no tienen fecha de fallecimiento
		List<Persona> lista = rp.buscarNoFallecidos();
		assertTrue((lista.size()==2)&&(lista.contains(oscar)&&lista.contains(maria)));
	}
	
	@Test
	public void buscarPorPatronDeNombre() {
		assertEquals(rp.buscarPorPatronPrimerNombre("Oscar"), rp.findByPrimerNombreLike("Oscar"));
	}
	
	@Test
	public void buscarPorRangoFechaNacimiento() {
		assertEquals(rp.buscarPorRangoFechaNacimiento(new Date(2000,1,1), new Date(2002,11,31)), 
				rp.findByNacimientoBetween(new Date(2000,1,1), new Date(2002,11,31)) );
	}
	
}
