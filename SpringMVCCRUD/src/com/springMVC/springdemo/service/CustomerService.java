package com.springMVC.springdemo.service;

import java.util.List;

import com.springMVC.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);
}
