package com.ercan.controller;

import com.ercan.entity.Book;
import com.ercan.exception.BookNotFoundException;
import com.ercan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllBook(){
        return ResponseEntity.ok(bookService.getAllBook());
    }

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody @Validated Book book){
        return ResponseEntity.ok(bookService.save(book));
    }

    @PutMapping
    public ResponseEntity<?> updateBook(@RequestBody @Validated Book book) throws BookNotFoundException {
        return ResponseEntity.ok(bookService.update(book));
    }

}
