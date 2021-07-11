package com.lg.pojo;

public class Author {
    protected int id;
    protected String username;
    protected String password;
    protected String email;
    protected String bio;

    protected Section favouriteSection;

    public Author(int id) {
        this(id, null, null, null, null, null);
    }

    public Author(Integer id, String username, String password, String email, String bio) {
        this(id, username, password, email, bio, Section.NEWS);
    }

    public Author(Integer id, String username, String password, String email, String bio, Section section) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.bio = bio;
        this.favouriteSection = section;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getBio() {
        return bio;
    }

    public Section getFavouriteSection() {
        return favouriteSection;
    }
}
