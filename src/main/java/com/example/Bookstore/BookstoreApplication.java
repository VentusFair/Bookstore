package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.Books.Book;
import com.example.Bookstore.Books.BookRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookApp(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("How to Become God", "Madoka Kaname", 2011, "some ISBN, I do not even know its format", 10));
			repository.save(new Book("How to Become Devil and Steal Madoka's Pantsu in the Process", "Homura Akemi", 2013, "6969-6969-6969-6969", 20));	
			
			log.info("fetch all students");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
