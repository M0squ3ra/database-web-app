package com.example.demo.controller;

import com.example.demo.data.CustomerRepository;
import com.example.demo.domain.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = {"/","/customer/list"})
    public String listCustomers(Model model){
        List<Customer> customerList = customerService.getCustomers();
        model.addAttribute("customers",customerList);
        
        return "list-customers";
    }


}
