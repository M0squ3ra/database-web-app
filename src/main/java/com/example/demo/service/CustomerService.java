package com.example.demo.service;

import com.example.demo.domain.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer);
}
