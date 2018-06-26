package com.springMVC.springdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springMVC.springdemo.entity.Customer;
import com.springMVC.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//Inject DAO
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value="/list")
	public String listCustomers(Model model) {
		
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers",customers);
		System.out.println("Customer list: " + customers);
		return "list-customers"; 
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		
		model.addAttribute("customer",customer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer (@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
}
