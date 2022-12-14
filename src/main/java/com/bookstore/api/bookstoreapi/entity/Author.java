package com.bookstore.api.bookstoreapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {
    @Id
    private String authorName;
    private String birthDate;

    public Author() {}

    public Author(String authorName, String birthDate){
        this.authorName = authorName;
        this.birthDate = birthDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

}
