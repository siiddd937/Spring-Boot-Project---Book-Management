package com.boot.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.book.entity.Book;
import com.boot.book.repository.bookRepo;

@Service
public class bookServiceImpli implements bookService {
	
	@Autowired
	private bookRepo bookrepo;
	
//	private static List<Book> list= new ArrayList<>();
//	
//	static {
//		list.add(new Book(1011,"Amazing India","XYZ"));
//		list.add(new Book(1022,"Lazy Gaze","XYZ"));
//		list.add(new Book(1033,"Game Changer","XYZ"));
//		list.add(new Book(1044,"Browse Mind","XYZ"));
//	}
	
	//Get All Books
	public List<Book> getMultibooks()
	{
		List<Book> list =(List<Book>) this.bookrepo.findAll();
		
		return list;
	}
	
	//Get Single book
	public Book getbookbyId(int id)
	{
		Book book=null;
		try {
//			book = list.stream().filter(e->e.getId()==id).findFirst().get();
			
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		
		return this.bookrepo.findById(id)
				.orElseThrow(()-> new RuntimeException("Book not found with id: "+ id));
		
		
	            	}
	
	//Add the Book
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
//		try {
////			list.add(book);	
//			Book save = this.bookrepo.save(book);
//			System.out.println(save);
//			
//		} catch (Exception e) {
//			e.getMessage();
//		}
//		return book;
		
//		Book b=null;
//		b= 
		
		return bookrepo.save(book);
	}
	
	//Delete the book
	public void deleteBook(int id)
	{
		try {
//			list = list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
//			System.out.println(id);
			
			this.bookrepo.deleteById(id);
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	//Update the Data
	public void updatebookbyId(Book book,int id)
	{
//		try {
//			list.forEach(b->{
//				if(b.getId()==id)
//				{
//					b.setName(book.getName());
//					b.setAuthor(book.getAuthor());
//				}
//				
//			});
			
			
//			Optional<Book> optional = this.bookrepo.findById(id);
//			
//			if(optional.isPresent())
//			{
//				Book book2 = optional.get();
//				book2.setName(book.getName());
//				book2.setAuthor(book.getAuthor());
//				
//				bookrepo.save(book2);
				
				book.setId(id);
				bookrepo.save(book);
				
				
				    		
				       
			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		
		/* OR
		 * 
		 */
		
//		list = list.stream().map(b->{
//			b.setName(book.getName());
//			b.setAuthor(book.getAuthor());
//			
//			return b;
//		}).collect(Collectors.toList());
		
		
	}
	
}
