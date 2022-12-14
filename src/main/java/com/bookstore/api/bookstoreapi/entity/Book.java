package com.bookstore.api.bookstoreapi.entity;


import javax.persistence.*;


import java.util.List;

@Entity
public class Book {
    @Id
    private String isbn;
    private String title;
    @ManyToMany
    private List<Author> authors;
    private int publishedYear;private double price;
    private String genre;

    public Book() {}

    public Book(String isbn, String title, List<Author> authors, int publishedYear, double price, String genre) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.publishedYear = publishedYear;
        this.price = price;
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book id=" + getIsbn();
    }
}
