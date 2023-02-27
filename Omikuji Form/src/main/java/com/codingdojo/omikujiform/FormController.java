package com.codingdojo.omikujiform;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/omikuji")
public class FormController {
	
	//Display form
	@GetMapping("/showform")
	public String displayForm() {
		return "index.jsp";
		}
	
	//Process form
	@PostMapping("/submit")
	public String processForm(@RequestParam(value="number") Integer number, @RequestParam(value="city") String city, 
			@RequestParam(value="person") String person, @RequestParam(value="hobby") String hobby, @RequestParam(value="thing") String thing,
			@RequestParam(value="compliment") String compliment, Model model, HttpSession session) {
			model.addAttribute("number", number);
			model.addAttribute("city", city);
			model.addAttribute("person", person);
			model.addAttribute("hobby", hobby);
			model.addAttribute("thing", thing);
			model.addAttribute("compliment", compliment);
			session.setAttribute("number", number);
			session.setAttribute("city", city);
			session.setAttribute("person", person);
			session.setAttribute("hobby", hobby);
			session.setAttribute("thing",thing);
			session.setAttribute("compliment", compliment);
			return "redirect:/omikuji/show";
		}
	
	//Display results after submitting form
	@GetMapping("/show")
	public String showPostForm(HttpSession session, Model model) {
		session.getAttribute("number");
		session.getAttribute("name");
		session.getAttribute("person");
		session.getAttribute("hobby");
		session.getAttribute("thing");
		session.getAttribute("compliment");
		return "show.jsp";
	}
}