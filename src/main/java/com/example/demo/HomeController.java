package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CarsRepository carsRepository;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("cars", carsRepository.findAll());
        return "home";
    }

    @GetMapping("/addCar")
    public String addCar(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("car", new Cars());
        return "carForm";
    }

}
