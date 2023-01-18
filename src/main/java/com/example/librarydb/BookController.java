package com.example.librarydb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add_book")
    public void addBook(@RequestBody()Book book){
        try {
            bookService.createBook(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/get_book")
    public void getBook(@RequestParam("id")Integer id)
    {
        try {
            bookService.getBookById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
