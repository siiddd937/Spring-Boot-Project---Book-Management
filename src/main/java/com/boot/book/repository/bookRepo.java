package com.boot.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.book.entity.Book;

public interface bookRepo extends JpaRepository<Book, Integer>{

	
}
