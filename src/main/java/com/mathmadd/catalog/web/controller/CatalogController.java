package com.mathmadd.catalog.web.controller;

import org.openwms.core.http.Index;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController("catalogIndexController")
@RequestMapping(value = "/v1/catalog")
class CatalogController {

    @GetMapping("/index")
    public ResponseEntity<Index> getCatalogIndex() throws Exception {
        return ResponseEntity.ok(
                new Index(
                        linkTo(methodOn(BookController.class).bookIndex()).withRel("book-index")
                )
        );
    }
}
