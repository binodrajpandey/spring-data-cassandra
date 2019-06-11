/**
 * To change this license header,choose License Headers in Project Properties.*To change this
 * template file,choose Tools|Templates*and open the template in the editor.
 */
package com.goldenhandshake.demo;

import static org.junit.Assert.assertEquals;

import com.datastax.driver.core.utils.UUIDs;
import com.google.common.collect.ImmutableSet;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/****
 * 
 * @author binod
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class BookRepositoryTest {

  @Autowired
  private BookRepository bookRepository;


  @After
  public void after() {
    bookRepository.deleteAll();

  }

  @Test
  public void saveBook() {
    Book javaBook = new Book();
    javaBook.setBookKey(new BookKey());
    javaBook.getBookKey().setId(UUIDs.timeBased());
    javaBook.getBookKey().setPublisher("O'Reilly Media");
    javaBook.getBookKey().setTitle("Head First Java");
    javaBook.setTags(ImmutableSet.of("Computer", "Software"));
    bookRepository.save(javaBook);
    Iterable<Book> books = bookRepository.findByTitleAndPublisher(
        "Head First Java", "O'Reilly Media");
    assertEquals(javaBook.getBookKey().getId(), books.iterator().next().getBookKey().getId());

  }

  @Test
  public void updateTest() {
    Book javaBook = new Book();
    javaBook.setBookKey(new BookKey());
    javaBook.getBookKey().setId(UUIDs.timeBased());
    javaBook.getBookKey().setPublisher("O'Reilly Media");
    javaBook.getBookKey().setTitle("Head First Java");
    javaBook.setTags(ImmutableSet.of("Computer", "Software"));
    bookRepository.save(javaBook);
    Iterable<Book> books = bookRepository.findByTitleAndPublisher(
        "Head First Java", "O'Reilly Media");
    javaBook.getBookKey().setTitle("Head First Java Second Edition");
    bookRepository.save(javaBook);
    Iterable<Book> updatedBooks = bookRepository.findByTitleAndPublisher(
        "Head First Java Second Edition", "O'Reilly Media");
    assertEquals(
        javaBook.getBookKey().getTitle(), updatedBooks.iterator().next().getBookKey().getTitle());

  }

  @Test
  public void deleteBook() {
    Book javaBook = new Book();
    javaBook.setBookKey(new BookKey());
    javaBook.getBookKey().setId(UUIDs.timeBased());
    javaBook.getBookKey().setPublisher("O'Reilly Media");
    javaBook.getBookKey().setTitle("Head First Java");
    javaBook.setTags(ImmutableSet.of("Computer", "Software"));
    bookRepository.save(javaBook);
    bookRepository.delete(javaBook);
    // Now we can check for the deletion:

    List<Book> books = (List<Book>) bookRepository.findByTitleAndPublisher(
        "Head First Java", "O'Reilly Media");
    assertEquals(0, books.size());

  }
}
