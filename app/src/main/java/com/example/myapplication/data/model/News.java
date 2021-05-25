package com.example.myapplication.data.model;

public class News {
    private int IdNews;
    private String Title;
    private String Description;
    private String Author;
    private String Picture;

    public void setIdNews(int idNews) {
        IdNews = idNews;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public int getIdNews() {
        return IdNews;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getAuthor() {
        return Author;
    }

    public String getPicture() {
        return Picture;
    }

    public News(int idNews, String title, String description, String author, String picture) {
        IdNews = idNews;
        Title = title;
        Description = description;
        Author = author;
        Picture = picture;
    }
}
