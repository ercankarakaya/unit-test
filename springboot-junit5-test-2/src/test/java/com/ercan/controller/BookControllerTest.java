package com.ercan.controller;

import com.ercan.entity.Book;
import com.ercan.repository.BookRepository;
import com.ercan.service.BookService;
import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(MockitoJUnitRunner.class)
class BookControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private BookController bookController;
    @Mock
    private BookService bookService;


    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    void setUp() {
        book1 = new Book(1L, "The Lord Of The Rings", "summary1", 7);
        book2 = new Book(2L, "Harry Potter", "summary2", 6);
        book3 = new Book(3L, "Clean Code", "summary3", 6);

        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    void getBookById() {
    }

    @Test
    void getAllBook() throws Exception{
        List<Book> bookList = new ArrayList<>(Arrays.asList(book1,book2,book3));

        when(bookService.getAllBook()).thenReturn(bookList);

       /* ResponseEntity<?> bookList2 =  bookController.getAllBook();
        assertNotNull(bookList2.getBody()); */

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/book")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(3)))
                .andExpect(jsonPath("$[1].name",is("Harry Potter")));

    }

    @Test
    void saveBook() {
    }

    @Test
    void updateBook() {
    }
}