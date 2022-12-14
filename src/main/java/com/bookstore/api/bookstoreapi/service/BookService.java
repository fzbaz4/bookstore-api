package com.bookstore.api.bookstoreapi.service;

import com.bookstore.api.bookstoreapi.entity.Book;
import com.bookstore.api.bookstoreapi.entity.ExceptionMessage;
import com.bookstore.api.bookstoreapi.exception.CustomException;
import com.bookstore.api.bookstoreapi.interfaces.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    private static final Logger log = LoggerFactory.getLogger(BookService.class);


    // CREATE
    public Book addBook(Book newBook) {
        return bookRepository.save(newBook);
    }

    // READ
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> searchBooks(String authorName, String title) {

        return ExceptionMessage.requireNotEmpty(bookRepository.findAll(where(hasAuthor(authorName)).and(titleContains(title))));
    }

    public List<Book> searchTitle(String title) {
        return ExceptionMessage.requireNotEmpty(bookRepository.findAll(where(titleContains(title))));
    }

    public List<Book> searchAuthor(String authorName) {
        return ExceptionMessage.requireNotEmpty(bookRepository.findAll(where(hasAuthor(authorName))));
    }

    // DELETE
    public void deleteBook(String isbn) {
        bookRepository.deleteById(isbn);
    }

    // UPDATE
    public Book updateBook(String isbn, Book bookDetails) {
        Book book = bookRepository.findById(isbn).get();
        book.setAuthors(bookDetails.getAuthors());
        book.setIsbn(bookDetails.getIsbn());
        book.setGenre(bookDetails.getGenre());
        book.setPrice(bookDetails.getPrice());
        book.setTitle(bookDetails.getTitle());
        book.setPublishedYear(bookDetails.getPublishedYear());
        return bookRepository.save(book);
    }

    static Specification<Book> hasAuthor(String author) {
        return (book, cq, cb) -> cb.like(book.join("authors").get("authorName"), author);
    }

    static Specification<Book> titleContains(String title) {
        return (book, cq, cb) -> cb.like(book.get("title"), "%" + title + "%");
    }


}
