package com.example.librarydb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;



    public void createBook(Book book) throws Exception{


        bookRepository.save(book);
    }

    public Book getBookById(Integer id) throws Exception {
        Book book = bookRepository.findById(id). get();

        System.out.println(book.getName());

        return book;
    }


    public void updateBookPages(UpdateBookPages updateBookPages) {
        // we need to enter an object

        int id = updateBookPages.getId();

        Book bookToBUpdated = bookRepository.findById(id).get();

        bookToBUpdated.setPages(updateBookPages.getPages());

        bookRepository.save(bookToBUpdated);
    }
}
