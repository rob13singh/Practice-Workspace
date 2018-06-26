package com.springMVC.springdemo.DAO;

import java.util.List;

import com.springMVC.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);
}
