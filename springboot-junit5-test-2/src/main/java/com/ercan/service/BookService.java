package com.ercan.service;

import com.ercan.entity.Book;
import com.ercan.exception.BookNotFoundException;
import com.ercan.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public Book save(Book book){
        return bookRepository.save(book);
    }

    public Book update(Book book) throws BookNotFoundException {
        if (book == null || book.getId() == null){
            throw new BookNotFoundException("Book or ID must not be null!");
        }
        Book bookDb = bookRepository.findById(book.getId()).orElseThrow(()->new BookNotFoundException("Book not found!"));
        bookDb.setName(book.getName());
        bookDb.setSummary(book.getSummary());
        bookDb.setRating(book.getRating());
        return bookRepository.save(bookDb);
    }

    public Book getBookById(Long id){
        return bookRepository.getById(id);
    }
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

}
