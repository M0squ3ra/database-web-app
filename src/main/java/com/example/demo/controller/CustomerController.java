package com.example.demo.controller;

import com.example.demo.data.CustomerRepository;
import com.example.demo.domain.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = {"/","/customer"})
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = {"/","/list"})
    public String listCustomers(Model model){
        List<Customer> customerList = customerService.getCustomers();
        model.addAttribute("customers",customerList);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Customer customer = new Customer();
        model.addAttribute("customer",customer);

        return "customer-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") long id, Model model){
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer",customer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") long id){
        customerService.deleteCustomer(id);

        return "redirect:/customer/list";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }


}
