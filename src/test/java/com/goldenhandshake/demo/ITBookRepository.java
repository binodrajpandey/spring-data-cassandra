/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldenhandshake.demo;

import com.datastax.driver.core.utils.UUIDs;
import com.google.common.collect.ImmutableSet;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author binod
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CassandraConfig.class, DemoApplication.class})
public class ITBookRepository {

    @Autowired
    private BookRepository bookRepository;

    @Before
    public void before() {
    }

    @After
    public void after() {
        bookRepository.deleteAll();

    }

    @Test
    public void saveBook() {
        Book javaBook = new Book(
                UUIDs.timeBased(), "Head First Java", "O'Reilly Media",
                ImmutableSet.of("Computer", "Software"));
        bookRepository.save(ImmutableSet.of(javaBook));
        Iterable<Book> books = bookRepository.findByTitleAndPublisher(
                "Head First Java", "O'Reilly Media");
        assertEquals(javaBook.getId(), books.iterator().next().getId());

    }

    @Test
    public void updateTest() {
        Book javaBook = new Book(
                UUIDs.timeBased(), "Head First Java", "O'Reilly Media",
                ImmutableSet.of("Computer", "Software"));
        bookRepository.save(ImmutableSet.of(javaBook));
        Iterable<Book> books = bookRepository.findByTitleAndPublisher(
                "Head First Java", "O'Reilly Media");
        javaBook.setTitle("Head First Java Second Edition");
        bookRepository.save(ImmutableSet.of(javaBook));
        Iterable<Book> updatedBooks = bookRepository.findByTitleAndPublisher(
                "Head First Java Second Edition", "O'Reilly Media");
        assertEquals(
                javaBook.getTitle(), updatedBooks.iterator().next().getTitle());

    }

    @Test
    public void deleteBook() {
        Book javaBook = new Book(
                UUIDs.timeBased(), "Head First Java", "O'Reilly Media",
                ImmutableSet.of("Computer", "Software"));
        bookRepository.save(ImmutableSet.of(javaBook));
        bookRepository.delete(javaBook);
//Now we can check for the deletion:

        List<Book> books = (List<Book>) bookRepository.findByTitleAndPublisher(
                "Head First Java", "O'Reilly Media");
        assertEquals(0, books.size());

    }
}
