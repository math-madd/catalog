package com.mathmadd.catalog.config;

import com.mathmadd.catalog.model.BookStatus;
import com.mathmadd.catalog.repository.BookRepository;
import com.mathmadd.catalog.model.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository) {
        return args -> {
           Book foundryside = new Book(
                    "9781524760366",
                    "Foundryside",
                    "Bennett",
                    "Robert Jackson",
                    "Crown",
                    "Fantasy",
                    512,
                   BookStatus.CURRENTLY_READING.getLabel()
        );
           Book adsom = new Book(
                    "9780765376459",
                    "A Darker Shade of Magic",
                    "Schwab",
                    "Victoria",
                    "Tor",
                    "Fantasy",
                    400,
                   BookStatus.READ.getLabel()
            );

           bookRepository.saveAll(
                   List.of(foundryside, adsom)
           );

        };
    }
}
