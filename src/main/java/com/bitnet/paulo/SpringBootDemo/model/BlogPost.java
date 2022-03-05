package com.bitnet.paulo.SpringBootDemo.model;

import java.io.Serializable;
import java.time.LocalDate;

public class BlogPost implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String text;
    private String img_url = "http://localhost:8081/img/a.jpg";
    private LocalDate date = LocalDate.now();

    public BlogPost(int id, String title, String text, String img_url, LocalDate date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.img_url = img_url;
        this.date = date;
    }

    public BlogPost() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
