package com.example.demo.service;

import com.example.demo.data.CustomerRepository;
import com.example.demo.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(long id) {
        Optional<Customer> customerOpt = customerRepository.findById(id);
        Customer customer;
        if(customerOpt.isPresent()){
            customer = customerOpt.get();
        } else {
            customer = null;
        }
        return customer;
    }

    @Override
    @Transactional
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }
}
