package com.example.waterbillingsystem;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


//    @GetMapping("")
//    public String showLoginPage() {
//        return "loginpage";
//    }

    @GetMapping("")
    public String showDashboard() {
        return "Dashboard";
    }




}