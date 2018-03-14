package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.Books.Book;
import com.example.Bookstore.Books.BookRepository;
import com.example.Bookstore.Books.User;
import com.example.Bookstore.Books.UserRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookApp(BookRepository brepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			brepository.save(new Book("How to Become God", "Madoka Kaname", 2011, "some ISBN, I do not even know its format", 10));
			brepository.save(new Book("How to Become Devil and Steal Madoka's Pantsu in the Process", "Homura Akemi", 2013, "6969-6969-6969-6969", 20));	
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			User user3 = new User("Halonen", "$2a$04$nvk/b054z7TrZ0W9fsBXWu7rCaq5COS1wHBkj8RZHecA5SSDcwHQ6", "ADMIN");
			User user4 = new User("Irpola", "$2a$06$0kqGwL49l6CqzGhVhXEDzegmJRvxqYkMPsSZir5BqQva0Q5QE5YRy", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			urepository.save(user4);
			
			log.info("fetch all students");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
