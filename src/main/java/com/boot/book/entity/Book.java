package com.boot.book.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Book_Project")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference //JSON attribute use to Parent
	private Author author;
	
//	@Version -Declares the version field or property of an entity class, which
//	 * is used to detect optimistic lock failures, ensuring the integrity
//	 * of optimistic transactions. The version field or property holds a
//	 * version number or timestamp identifying the revision of the entity
//	 * data held by an entity class instance.
//	 private Integer version;
	
	public Book(Integer id, String name, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
