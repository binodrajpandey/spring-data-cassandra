/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.goldenhandshake.demo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author binod
 */
@Repository
public interface BookRepository extends CassandraRepository<Book, BookKey> {

  @Query("SELECT * FROM Book WHERE title = ?0 and publisher = ?1 ALLOW FILTERING")
  public Iterable<Book> findByTitleAndPublisher(String title, String publisher);

}
