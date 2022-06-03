package com.example.accessingdatajpa.controller;


import com.example.accessingdatajpa.dto.ClickOrders;
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
@RequestMapping("orders")
public class ClickOrdersController {

    @Autowired
    private CustomerRepository customerRepository;
    private ClickOrderRepository clickOrderRepository;

    @GetMapping("list")
    public String showAllcustomers(Model model) {
        model.addAttribute("clickOrders", clickOrderRepository.findAll());
        return "clickOrders-list";
    }

    @PostMapping("add")
    @Async
    public String addCustomer(ClickOrders clickOrders, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "clickOrders-add";
        }
        clickOrderRepository.save(clickOrders);

        return "redirect:list";
    }
}
