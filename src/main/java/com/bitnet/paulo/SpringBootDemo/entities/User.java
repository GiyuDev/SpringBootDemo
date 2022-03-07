package com.bitnet.paulo.SpringBootDemo.entities;

public class User {

    private String name;
    private String last_name;

    public User(String name, String last_name) {
        this.name = name;
        this.last_name = last_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
