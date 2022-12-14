package com.bookstore.api.bookstoreapi.service;

import com.bookstore.api.bookstoreapi.entity.Author;
import com.bookstore.api.bookstoreapi.interfaces.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public Author addAuthor(Author newAuthor) {
        return authorRepository.save(newAuthor);
    }
}
