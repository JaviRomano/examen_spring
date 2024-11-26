package com.example.evaluacion1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.evaluacion1.entity.Edificio;
import com.example.evaluacion1.service.EdificioService;
import com.example.evaluacion1.service.IEdificioService;

@Controller
@RequestMapping("/edificio")
public class EdificioController {

	@ModelAttribute(name = "titulo")
	public String titulo() {
		return "edificio";
	}
	
	@Autowired
	private IEdificioService edificioService;
	
	public EdificioController(EdificioService edificioService) {
		this.edificioService = edificioService;
	}
	
	@GetMapping("/list")
	public String getAllEdificios(Model model) {
		model.addAttribute("edificios", edificioService.getAllEdificios());
		return "edificio/list";
	}
	
	@GetMapping("/show/{id}")
	public String getEdificioById(Model model, @PathVariable Long id) {
		model.addAttribute("edificio", edificioService.findById(id).orElse(null));
		return "edificio/solo";
	}
	

	@GetMapping("/delete/{id}")
	public String deleteEdificioById(Model model, @PathVariable Long id) {
		edificioService.deleteById(id);		
		return "redirect:/edificio/listaEdificios";
	}
	
	@GetMapping("/form/{id}")
	public String editEdificio(Model model, @PathVariable Long id) {
		model.addAttribute("edificio", edificioService.findById(id).orElse(new Edificio()));
		return "edificio/form";
	}
	
	@GetMapping("/form")
	public String newEdificio(Model model) {
		model.addAttribute("edificio", new Edificio());
		return "edificio/form";
	}
	
	@PostMapping("/form")
	public String saveExistingProduct(Model model, Edificio edificio) {
		edificioService.save(edificio);
		return "redirect:/edificio/list";
	}
	
}
