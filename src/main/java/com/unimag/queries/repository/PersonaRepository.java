package com.unimag.queries.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unimag.queries.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	
	//Buscar persona por identificacion utilizando metodos de consulta
	Persona findByNumeroIdentificacion(String identificacion);
	
	//Buscar persona por identificacion utilizando query definida
	@Query("SELECT p FROM Persona p WHERE p.numeroIdentificacion = :numero")
	Persona buscarPorIdentificacion(@Param("numero")String identificacion);
	
	//Buscar persona por nombre y apellido utilizando metodos de consulta
	Persona findByPrimerNombreAndPrimerApellido(String pNombre, String pApellido);
	
	//Buscar persona por nombre y apellido utilizando query definida
	@Query("SELECT p FROM Persona p WHERE p.primerNombre = :nombre AND p.primerApellido = :apellido")
	Persona buscarPorNombreYApellido(@Param("nombre")String pNombre, @Param("apellido")String pApellido);
	
	//Buscar personas que aún no han fallecido o se desconoce fecha de fallecimiento - metodo de consulta
	List<Persona> findByFallecimientoIsNull();
	
	//Buscar personas que aún no han fallecido o se desconoce fecha de fallecimiento - query definida
	@Query("SELECT p FROM Persona p WHERE p.fallecimiento IS NULL")
	List<Persona> buscarNoFallecidos();
	
	//Buscar personas que tengan un patron en su primer nombre
	List<Persona> findByPrimerNombreLike(String pattern);
	
	//Buscar personas que empiece con un patron en su primer nombre
	@Query("SELECT p FROM Persona p WHERE p.primerNombre LIKE :patron%")
	List<Persona> buscarPorPatronPrimerNombre(@Param("patron")String pattern);
	
	//Buscar personas por rango de fecha de nacimiento (lo cual sería lo mismo para edad) por metodo de consulta
	List<Persona> findByNacimientoBetween(Date inferior, Date  superior);
	
	//Buscar personas por rango de fecha de nacimiento (lo cual sería lo mismo para edad) por consulta definida
	@Query("SELECT p FROM Persona p WHERE p.nacimiento BETWEEN :inf AND :sup")
	List<Persona>buscarPorRangoFechaNacimiento(@Param("inf") Date inferior, @Param("inf") Date  superior);
	
	

}
