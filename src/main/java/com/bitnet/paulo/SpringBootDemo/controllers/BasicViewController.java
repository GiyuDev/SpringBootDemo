package com.bitnet.paulo.SpringBootDemo.controllers;

import com.bitnet.paulo.SpringBootDemo.model.BlogPost;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Controller
@RequestMapping(path = "home")
public class BasicViewController {

    public List<BlogPost> getAllBlogPost() {
        return List.of(
                new BlogPost(1, "Post prueba", "Este es un post de prueba insertado desde un modelo", "http://localhost:8081/img/a.jpg", LocalDate.of(2022, Month.MARCH, 3)),
                new BlogPost(2, "Post prueba 2", "Este es un post de prueba insertado desde un modelo 2", "http://localhost:8081/img/a.jpg", LocalDate.of(2022, Month.MARCH, 3)),
                new BlogPost(2, "Post prueba 3", "Este es un post de prueba insertado desde un modelo 3", "http://localhost:8081/img/a.jpg", LocalDate.of(2022, Month.MARCH, 3))
        );
    }

    @GetMapping(path = {"post", ""})
    public String hello(Model model) {
        model.addAttribute("posts", getAllBlogPost());
        return "index";
    }
}
