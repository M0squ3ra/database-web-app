package com.example.demo.service;

import com.example.demo.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer);
    public Customer getCustomer(long id);
    public void deleteCustomer(long id);

}
