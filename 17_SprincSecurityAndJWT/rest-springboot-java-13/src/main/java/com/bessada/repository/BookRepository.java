package com.bessada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bessada.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{}
