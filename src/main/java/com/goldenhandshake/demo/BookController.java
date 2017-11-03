/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldenhandshake.demo;

import com.datastax.driver.core.utils.UUIDs;
import com.google.common.collect.ImmutableSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author binod
 */
@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    
    @PostMapping("/books")
    public void saveBook(){
        System.out.println("request arrive");
        Book javaBook = new Book(
  UUIDs.timeBased(), "Head First Java", "O'Reilly Media", 
  ImmutableSet.of("Computer", "Software"));
        System.out.println("saving book");
bookRepository.save(javaBook);
        
    }
    @GetMapping("/books")
    public ResponseEntity<?> getBooks(){
        Iterable<Book> books = bookRepository.findAll();
//                bookRepository.findByTitleAndPublisher(
//  "Head First Java", "O'Reilly Media");
//assertEquals(javaBook.getId(), books.iterator().next().getId());
return ResponseEntity.ok(books);
    }
    
}
