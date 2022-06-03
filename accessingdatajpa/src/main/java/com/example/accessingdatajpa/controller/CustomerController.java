package com.example.accessingdatajpa.controller;


import com.example.accessingdatajpa.dto.Customer;
import com.example.accessingdatajpa.repository.ClickOrderRepository;
import com.example.accessingdatajpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    private ClickOrderRepository clickOrderRepository;

    @GetMapping("list")
    public String showAllcustomers(Model model) {
        model.addAttribute("customer", customerRepository.findAll());
        return "cusromer-list";
    }

    @GetMapping("list/{id}")
    public String showCustomerId(@PathVariable("id") long id, Model model) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer id: " + id));
        model.addAttribute("customer", customer);
        return "customer-viev";
    }

    @PostMapping("add")
    @Async
    public String addCustomer(Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("clickorders", clickOrderRepository.findAll());
            return "customer-add";
        }
        customerRepository.save(customer);

        return "redirect:list";
    }

}
