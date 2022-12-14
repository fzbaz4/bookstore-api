package com.bookstore.api.bookstoreapi;

import com.bookstore.api.bookstoreapi.entity.Author;
import com.bookstore.api.bookstoreapi.entity.Book;
import com.bookstore.api.bookstoreapi.interfaces.BookRepository;
import com.bookstore.api.bookstoreapi.service.AuthorService;
import com.bookstore.api.bookstoreapi.service.BookService;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Configuration
class DBLoad {

    private static final Logger log = LoggerFactory.getLogger(DBLoad.class);

    @Bean
    CommandLineRunner initDatabase(BookService bookService, AuthorService authorService) {

        List<Author> listOfAuthors1 = generateMockListOfAuthors();
        List<Author> listOfAuthors2 = generateMockListOfAuthors();
        List<Author> listOfAuthors3 = generateMockListOfAuthors();
        return args -> {
            log.info("Preloading Authors" );
            listOfAuthors1.stream().forEach((c) -> authorService.addAuthor(new Author(c.getAuthorName(),c.getBirthDate())));
            listOfAuthors2.stream().forEach((c) -> authorService.addAuthor(new Author(c.getAuthorName(),c.getBirthDate())));
            listOfAuthors3.stream().forEach((c) -> authorService.addAuthor(new Author(c.getAuthorName(),c.getBirthDate())));

            log.info("Preloading " + bookService.addBook(new Book("124145", "title1", listOfAuthors1,1991,10.4,"GENRE1" )));
            log.info("Preloading " + bookService.addBook(new Book("15151", "title2", listOfAuthors2,1992,10.5,"GENRE2" )));
            log.info("Preloading " + bookService.addBook(new Book("TE123ST3", "title3", listOfAuthors3,1993,10.6,"GENRE3" )));

        };

    }

    private String generateMockBirthday(){
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        return dateFormat.format(new Date(Math.abs(System.currentTimeMillis() - RandomUtils.nextLong())));
    }

    private int generateRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private List<Author> generateMockListOfAuthors() {
        List<Author> listOfAuthors= new ArrayList<>();
        for (int i = 0; i < generateRandomNumber(1, 4); i++) {
            Faker faker = new Faker();
            listOfAuthors.add(new Author(faker.name().firstName(), generateMockBirthday()));
        }
        return listOfAuthors;
    }

}