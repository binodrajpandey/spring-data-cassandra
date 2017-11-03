/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldenhandshake.demo;

import com.google.common.collect.ImmutableSet;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

/**
 *
 * @author binod
 */
@Table("book")
public class Book {
    @PrimaryKeyColumn(name = "isbn",ordinal = 2,type = PrimaryKeyType.CLUSTERED,ordering = Ordering.DESCENDING)
    private UUID id;
    @PrimaryKeyColumn(name = "title", ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    private String title;
    @PrimaryKeyColumn(name = "publisher", ordinal = 1,type = PrimaryKeyType.PARTITIONED)
    private String publisher;
    @Column
    private Set<String> tags=new HashSet<>();

    Book(UUID id, String title, String publisher, Set<String> tags) {
        this.id=id;
        this.title=title;
        this.publisher=publisher;
        this.tags=tags;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
    
}
