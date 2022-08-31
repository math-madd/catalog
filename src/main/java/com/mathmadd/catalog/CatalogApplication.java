package com.mathmadd.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(CatalogApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
