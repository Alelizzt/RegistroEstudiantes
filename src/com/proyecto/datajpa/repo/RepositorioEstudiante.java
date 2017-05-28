package com.proyecto.datajpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.datajpa.model.Estudiante;

@Repository
public interface RepositorioEstudiante extends JpaRepository<Estudiante, Long>{
	/* Realizar la búsqieda en base al nombre */
	public List<Estudiante> findByNombre(String nombre);
	
	/* Realizar la búsqueda en base al apellido*/
	public List<Estudiante> findByApellido(String apellido);
	
	/* Realizar la búsqueda en base al nombre y el apellido */
	public List<Estudiante> findByNombreAndApellido(String nombre, String apellido);
	
	/* Realizar la búsqueda en base al nombre y el apellido, y ordenar los resultados descendentemente por apellido */
	public List<Estudiante> findByNombreAndApellidoOrderByApellidoDesc(String nombre, String apellido);
}
