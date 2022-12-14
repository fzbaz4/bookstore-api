package com.bookstore.api.bookstoreapi.interfaces;

import com.bookstore.api.bookstoreapi.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, String> {

}