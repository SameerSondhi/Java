package com.codingdojo.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.services.DojoService;


@Controller
public class DojoController {

	@Autowired
	private DojoService dojoService;
	
	@GetMapping("/")
    public String index(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
        return "dashboard.jsp";
    }
	
	@GetMapping("/dojos/new")
    public String addDojo(@ModelAttribute("dojo") Dojo dojo, Model model) {
        return "newdojo.jsp";
    }
	
	@PostMapping("/")
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	List<Dojo> dojos = dojoService.allDojos();
        	model.addAttribute("dojos", dojos);
            return "newdojo.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/";
        }
	}
    
	@GetMapping("/dojos/{dojoId}")
	public String details(@PathVariable("dojoId") Long id, Model model) {
		Dojo dojo = dojoService.singleDojo(id);
		model.addAttribute("dojo", dojo);
		return "details.jsp";
}
	
}
