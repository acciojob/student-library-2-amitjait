package com.driver.services;

import com.driver.models.Book;
import com.driver.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository2;

    public void createBook(Book book){
        bookRepository2.save(book);
    }

    public List<Book> getBooks(String genre, boolean available, String author){
        List<Book> books = bookRepository2.findAll(); //find the elements of the list by yourself

        List<Book> filteredBook = new ArrayList<>();

        if(author == null){
            for(Book book: books){
                if(book.getGenre().equals(genre) && book.isAvailable() == available){
                    filteredBook.add(book);
                }
            }
        }else{
            for(Book book: books){
                if(book.getGenre().equals(genre) && book.isAvailable() == available && book.getAuthor().equals(author)){
                    filteredBook.add(book);
                }
            }
        }

        return filteredBook;
    }
}
