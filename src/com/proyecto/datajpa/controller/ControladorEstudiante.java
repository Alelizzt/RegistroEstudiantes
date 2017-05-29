package com.proyecto.datajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.datajpa.model.Estudiante;
import com.proyecto.datajpa.repo.RepositorioEstudiante;

@Controller
public class ControladorEstudiante {
	
	
	@Autowired
	private RepositorioEstudiante studentRepository;
	
	@RequestMapping(value ="/list", method = RequestMethod.GET)
	public String listaEstudiantes(Model model){
		
		model.addAttribute("ListaEstudiantes", studentRepository.findAll());
		return "list";
	}
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public String search(@RequestParam(name="nombreEst", required=false)String nombre, @RequestParam(name="apellidoEst",required=true)String apellido, Model model){
		List<Estudiante> result = null;
		if(nombre.isEmpty() && apellido.isEmpty())
			result=studentRepository.findAll();
		else if(!nombre.isEmpty() && apellido.isEmpty())
			result=studentRepository.findByNombre(nombre);
		else if(nombre.isEmpty() && !apellido.isEmpty())
			result=studentRepository.findByApellido(apellido);
		else
			result=studentRepository.findByNombreAndApellidoOrderByApellidoDesc(nombre, apellido);

		model.addAttribute("ListaEstudiantes", result);
		return "list";
	}
	
	@RequestMapping(value="/newStudent", method=RequestMethod.GET)
	public String showForm(Model model){
		
		Estudiante student = new Estudiante();
		model.addAttribute("studentForm", student);
		
		return "form";
	}
	
	@RequestMapping(value="/addStudent", method=RequestMethod.POST)
	public String submit(@ModelAttribute("studentForm") Estudiante student, Model model){
		
		studentRepository.save(student);
		return "redirect:/list";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String submitEdit(@ModelAttribute("studentForm") Estudiante student, Model model){
		
		studentRepository.save(student);
		return "redirect:/list";
	}
	
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String showFormEdit(@PathVariable("id") Long id, Model model){
		
		Estudiante student = studentRepository.findOne(id);
		model.addAttribute("studentForm", student);
		model.addAttribute("op","edit");
		
		return "form";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model){
		
		studentRepository.delete(id);
		
		return "redirect:/list";
	}
}
