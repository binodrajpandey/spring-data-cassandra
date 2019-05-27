/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.goldenhandshake.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 *
 * @author binod
 */
@Table("book")
public class Book {
  @PrimaryKey
  private BookKey bookKey;
  @Column
  private Set<String> tags = new HashSet<>();

  public BookKey getBookKey() {
    return bookKey;
  }

  public void setBookKey(BookKey bookKey) {
    this.bookKey = bookKey;
  }
  public Set<String> getTags() {
    return tags;
  }
  public void setTags(Set<String> tags) {
    this.tags = tags;
  }



}
