package com.bitnet.paulo.SpringBootDemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "holahtml")
public class BasicViewController {

    @GetMapping(path = {"saludar", "holamundo"})
    public String hello() {
        return "index";
    }
}
