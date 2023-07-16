package com.ercan.service;

import com.ercan.entity.Book;
import com.ercan.exception.BookNotFoundException;
import com.ercan.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public Book getBookById(Long id) throws BookNotFoundException {
        return bookRepository.findById(id)
                .orElseThrow(()->new BookNotFoundException("Book not found!"));
    }
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

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

    public void deleteBookById(Long id) throws BookNotFoundException {
        Book book = bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("Book not found!"));
        bookRepository.deleteById(book.getId());
    }

}
