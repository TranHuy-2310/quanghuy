package com.tuan3jpa.tuan3jpa.services;

import com.tuan3jpa.tuan3jpa.Repository.IBookRepository;
import com.tuan3jpa.tuan3jpa.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;

    public List<Book> getALLBooks(){
        return bookRepository.findAll();

    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }
    public void addBook(Book book){
        bookRepository.save(book);
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    //    public Book getBookById(Long id){
//        return bookRepository.findById(id).orElse(null);
//
//    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
    public void updateBook(Book book){
        bookRepository.save(book);
    }



}
