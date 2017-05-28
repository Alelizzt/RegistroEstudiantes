package com.proyecto.datajpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
@Entity
@Table(name="ESTUDIANTE")
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idEstudiante")
	private long id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	
	public Estudiante() {
		}
	
	public Estudiante(long id, String nombre, String apellido) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
}
