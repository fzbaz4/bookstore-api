package com.bookstore.api.bookstoreapi.controller;

import com.bookstore.api.bookstoreapi.entity.Book;
import com.bookstore.api.bookstoreapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    @Autowired
    BookService bookService;


    @RequestMapping(value="/all", method=RequestMethod.GET)
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book newBook) {
        return bookService.addBook(newBook);
    }
    @RequestMapping(value="/delete/{isbn}", method=RequestMethod.DELETE)
    public void deleteBook(@PathVariable(value = "isbn") String isbn) {
        bookService.deleteBook(isbn);
    }
    @RequestMapping(value="/search/{authorName}/{title}", method=RequestMethod.GET)
    public List<Book> searchBook(@PathVariable(value = "authorName") String authorName,
                           @PathVariable(value = "title") String title) {
        return bookService.searchBooks(authorName,title);
    }
    @RequestMapping(value="/title/{title}", method=RequestMethod.GET)
    public List<Book> searchTitle(@PathVariable(value = "title") String title) {
        return bookService.searchTitle(title);
    }
    @RequestMapping(value="/author/{author}", method=RequestMethod.GET)
    public List<Book> searchAuthor(@PathVariable(value = "author") String author) {
        return bookService.searchAuthor(author);
    }

    @RequestMapping(value="/update/{isbn}", method=RequestMethod.PUT)
    public Book updateBook(@RequestBody Book newBook,@PathVariable(value = "isbn") String isbn){
        return bookService.updateBook(isbn, newBook);
    }


}
