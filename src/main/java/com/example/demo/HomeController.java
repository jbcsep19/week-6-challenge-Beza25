package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/process_car")
    public String processCar(@ModelAttribute  Cars cars ){
        carsRepository.save(cars);
        return "redirect:/";
    }

    @GetMapping("/addCategory")
    public String addCategory(Model model){
        model.addAttribute("category", new Category());
        return "categoryFrom";
    }
    @PostMapping("/process_category")
    public String processCategory(@ModelAttribute Category category){
        categoryRepository.save(category);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String detailCar(@PathVariable("id") long idDetail, Model model){
        model.addAttribute("car", carsRepository.findById(idDetail).get());
        return "detail";
    }

    @RequestMapping("/update/{id}")
    public String updateCar(@PathVariable("id") long idUpdate, Model model){
        model.addAttribute("car", carsRepository.findById(idUpdate));
        return "carForm";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") long idDelete){
       carsRepository.deleteById(idDelete);
       return "redirect:/";
    }





}
