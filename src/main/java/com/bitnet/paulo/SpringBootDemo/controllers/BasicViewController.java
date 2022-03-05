package com.bitnet.paulo.SpringBootDemo.controllers;

import com.bitnet.paulo.SpringBootDemo.model.BlogPost;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "home")
public class BasicViewController implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum PagesReference {
        HOME("index"),
        POST("post"),
        FORM("form");

        public final String reference;

        PagesReference(String reference) {
            this.reference = reference;
        }

        public String getReference() {
            return this.reference;
        }

        public static String getReferenceByEnum(PagesReference pagesReference) {
            switch (pagesReference) {
                case HOME:
                    return HOME.getReference();
                case POST:
                    return POST.getReference();
                case FORM:
                    return FORM.getReference();
                default:
                    return "";
            }
        }
    }

    public List<BlogPost> getAllBlogPost() {
        List<BlogPost> list = new ArrayList<>();
        list.add(new BlogPost(1, "Post prueba", "Este es un post de prueba insertado desde un modelo", "http://localhost:8081/img/a.jpg", LocalDate.of(2022, Month.MARCH, 3)));
        list.add(new BlogPost(2, "Post prueba 2", "Este es un post de prueba insertado desde un modelo 2", "http://localhost:8081/img/a.jpg", LocalDate.of(2022, Month.MARCH, 3)));
        list.add(new BlogPost(3, "Post prueba 3", "Este es un post de prueba insertado desde un modelo 3", "http://localhost:8081/img/a.jpg", LocalDate.of(2022, Month.MARCH, 3)));
        return list;
    }

    @GetMapping
    public String show(Model model) {
        model.addAttribute("posts", getAllBlogPost());
        return "index";
    }

    @GetMapping(path = "posts")
    public ModelAndView posts() {
        ModelAndView modelAndView = new ModelAndView(PagesReference.getReferenceByEnum(PagesReference.HOME));
        modelAndView.addObject("posts", getAllBlogPost());
        return modelAndView;
    }

    @GetMapping(path = {"/post"})
    public ModelAndView getIndividualPostWithParams(@RequestParam(defaultValue = "1", name = "id", required = false) int id) {
        ModelAndView modelAndView = new ModelAndView(PagesReference.getReferenceByEnum(PagesReference.POST));

        Optional<BlogPost> post = Optional.of(this.getAllBlogPost().stream()
                .filter(p -> p.getId() == id).findFirst().get());

        modelAndView.addObject("post", post.get());
        return modelAndView;
    }

    @GetMapping(path = {"/post/{id}"})
    public ModelAndView getIndividualPostWithPathVariable(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView(PagesReference.getReferenceByEnum(PagesReference.POST));

        Optional<BlogPost> post = Optional.of(this.getAllBlogPost().stream()
                .filter(p -> p.getId() == id).findFirst().get());

        modelAndView.addObject("post", post.get());
        return modelAndView;
    }

    @GetMapping(path = {"/postform"})
    public ModelAndView getForm() {
        return new ModelAndView(PagesReference.getReferenceByEnum(PagesReference.FORM)).addObject("post", new BlogPost());
    }

    @PostMapping(path = {"/addNewPost"})
    public String addNewPost(BlogPost post, Model model) {
        List<BlogPost> blogPostList = this.getAllBlogPost();
        if (!blogPostList.contains(post)) {
            blogPostList.add(post);
            model.addAttribute("posts", blogPostList);
        }
        return "index";
    }
}
