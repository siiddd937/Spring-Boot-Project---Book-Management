package com.boot.book.service;

import java.util.List;

import com.boot.book.entity.Book;

public interface bookService {
	
	//Get Multiple Books
	public List<Book> getMultibooks();
	
	//Get Single Book
	public Book getbookbyId(int id);
	
	//Add new Book
	public Book addBook(Book book);
	
	//Delete Book
	public void deleteBook(int id);
	
	//Update Book
	public void updatebookbyId(Book book,int id);

}
