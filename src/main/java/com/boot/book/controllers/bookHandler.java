package com.boot.book.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.book.entity.Book;
import com.boot.book.service.bookService;

@RestController
public class bookHandler {

	@Autowired
	private bookService bs;
	
//	@GetMapping("/book")
//	public Book getAllbooks()
//	{
//		Book b=new Book();
//		b.setId(101);
//		b.setName("Amazing India");
//		b.setAuthor("XYZ");
//		
//		return b;	
//	}
	
	
//Get - List of Books
	@GetMapping("/book")
	public ResponseEntity<List<Book>> getAllbooks()
	{	
		List<Book> multibooks = this.bs.getMultibooks();	
		if(multibooks.size()<=0)
		{
			System.out.println("Book Not Found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}
		else
		{
			System.out.println("Books Found");
			return ResponseEntity.status(HttpStatus.CREATED).body(multibooks);
		}
	}
	
//Get - Single Book by id
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getSinglebook(@PathVariable("id") int id)
	{			
		Book getbookbyId = this.bs.getbookbyId(id);

			if(getbookbyId == null)
			{
				System.out.println("Book Not Found");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			else {
				System.out.println("Book Found");
			return  ResponseEntity.of(Optional.of(getbookbyId));
			}
			
	}
	
//Post- Add Book
	@PostMapping("/book")
	public ResponseEntity<Book> addNewBook(@RequestBody Book book)
	{
		book.setId(null);
		Book b;
		
		try {
			b = this.bs.addBook(book);
			System.out.println(book);
			return ResponseEntity.status(HttpStatus.CREATED).body(b);
			

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
			}
	
//Delete- Delete book
	@DeleteMapping("/book/{id}")
	public ResponseEntity<Void> deletemybook(@PathVariable("id") int id)
	{
		try {
			this.bs.deleteBook(id);
			return ResponseEntity.status(HttpStatus.OK).build();
			
		} catch (Exception e) {
			e.getMessage();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
//Put- Update Data
	@PutMapping("/book/{id}")
	public ResponseEntity<Book> updatemybook(@RequestBody Book book, @PathVariable("id") int id)
	{	
		try {
			this.bs.updatebookbyId(book, id);
			return ResponseEntity.ok().body(book);
			
			
		} catch (Exception e) {
			e.getMessage();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}		
	}
	
	
	
	
	
	
	
}
