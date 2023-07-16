package com.ercan.controller;

import com.ercan.entity.Book;
import com.ercan.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.notNullValue;
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

    private ObjectMapper objectMapper = new ObjectMapper();
    private ObjectWriter objectWriter = objectMapper.writer();

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
    void getBookById() throws Exception {
        when(bookService.getBookById(book1.getId())).thenReturn(book1);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/book/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",notNullValue()))
                .andExpect(jsonPath("$.name",is("The Lord Of The Rings")));
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
                .andExpect(jsonPath("$[1].name",is("Harry Potter")))
                .andExpect(jsonPath("$[0].rating",is(7)));

    }

    @Test
    void saveBook() throws Exception{
        Book book = Book.builder()
                .id(4L)
                .name("1984")
                .summary("summary4")
                .rating(6)
                .build();

        when(bookService.save(book)).thenReturn(book);

        String content = objectWriter.writeValueAsString(book);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/book")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",notNullValue()))
                .andExpect(jsonPath("$.name",is("1984")));

    }

    @Test
    void updateBook() throws Exception{
        Book updatedBook = Book.builder()
                .id(1L)
                .name("ABC")
                .summary("summary1_new")
                .build();

        when(bookService.getBookById(book1.getId())).thenReturn(book1);
        when(bookService.update(updatedBook)).thenReturn(updatedBook);

        String updatedContent = objectWriter.writeValueAsString(updatedBook);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/api/book")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(updatedContent);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",notNullValue()))
                .andExpect(jsonPath("$.name",is("ABC")));

    }

    @Test
    void deleteBookById() throws Exception{
        when(bookService.getBookById(book1.getId())).thenReturn(book1);

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/book/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}