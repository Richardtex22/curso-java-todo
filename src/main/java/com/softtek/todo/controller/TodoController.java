package com.softtek.todo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softtek.todo.model.TodoItem;
import com.softtek.todo.model.dao.TodoDao;

@Controller
public class TodoController {
	
	@Autowired
	private TodoDao todoDao;
	
	@RequestMapping(value="/inicio")
	public String inicio(Model model) {
		model.addAttribute("titulo", "Softtek Course");
		model.addAttribute("saludo", "Curso JavaWeb Todo App con SpringBoot, H2, Thymeleaf y Bootstrap");
		return "inicio";
	}
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Softtek Course");
		model.addAttribute("items", todoDao.findAll());
		return "listar";
	}
	
	
	@RequestMapping(value="/form")
	public String crear(Map<String, Object> model) {
		
		TodoItem item = new TodoItem();
		model.put("item", item);
		model.put("titulo", "Softtek Course");
		model.put("put", "Formulario de tareas");
		return "form";
	}
	

	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(TodoItem item) {
		
		todoDao.save(item);
		return "redirect:/listar";
	}
	

	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id > 0) {
			todoDao.delete(id);
		}
		return "redirect:/listar";
		
	}
}
