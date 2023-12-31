package com.company.chatterbook.models;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    private String name;
    private List<ChatterPost> chatterPosts = new ArrayList<>();

    public User(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChatterPost> getChatterPosts() {
        return chatterPosts;
    }

    public void setChatterPosts(List<ChatterPost> chatterPosts) {
        this.chatterPosts = chatterPosts;
    }
}
