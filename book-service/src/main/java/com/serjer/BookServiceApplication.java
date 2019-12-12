package com.serjer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serjer.dto.Book;

@SpringBootApplication
@RestController
public class BookServiceApplication {
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/findAllBooks")
	public List<Book> getBooks(){
		return Stream.of(new Book(101, "Java", 999),
						   new Book(102, "SQL", 95),
				           new Book(103, "Hibernate", 567),
				           new Book(104, "JavaScript", 124))
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

}
