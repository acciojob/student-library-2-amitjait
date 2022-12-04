package com.driver.services;

import com.driver.models.Book;
import com.driver.models.Genre;
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

//        all parameters are null or available is true
        if(genre == null && author == null){
            if(available == false){
                for(Book book: books){
                    if(book.isAvailable() == false){
                        filteredBook.add(book);
                    }
                }
            }else{
                for(Book book: books){
                    if(book.isAvailable() == true){
                        filteredBook.add(book);
                    }
                }
            }

            return filteredBook;
        }

//      if  author is null
        if(author == null){
            for(Book book: books){
                if(book.getGenre()== Genre.valueOf(genre) && book.isAvailable() == available){
                    filteredBook.add(book);
                }
            }

            return filteredBook;
        }


//      if genre is null
        if(genre == null){
            for(Book book: books){
                if(book.getAuthor().getName().equals(author) && book.isAvailable() == available){
                    filteredBook.add(book);
                }
            }

            return filteredBook;
        }

        return filteredBook;
    }
}
