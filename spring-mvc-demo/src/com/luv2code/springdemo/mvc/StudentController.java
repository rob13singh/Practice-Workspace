package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model model) {
	
		Student student = new Student();
		
		model.addAttribute("student",student);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String studentForm(@ModelAttribute("student") Student student){

		System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
		return "student-confirmation";
	}
	
	@RequestMapping("/test/{order}/{id}")
	public String test(@RequestParam("order") String order, @RequestParam("id") String id) {
		if(null != order && null != id) {
			return "Got it";
		}
		else return "Nope";
	}
}
