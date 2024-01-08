package com.ken.flowershop.controller;

import com.ken.flowershop.dao.CustomerDAO;
import com.ken.flowershop.dao.EmployeeRepository;
import com.ken.flowershop.dao.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private CustomerDAO customerDAO;
    private EmployeeRepository employeeRepository;
    private ProductRepository productRepository;

    @GetMapping("/")
    public String customers() {
        return "Hello World";
    }
}
