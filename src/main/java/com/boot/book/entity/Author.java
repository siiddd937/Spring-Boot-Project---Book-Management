package com.boot.book.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Book-Author")
@EntityListeners(AuditingEntityListener.class) //to enable @createddate
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer authorId;
	private String  authorName;
	
	@OneToOne
	@JsonBackReference //JSON attribute use to Child
	private Book book;
	
	@CreatedDate
	@Column(nullable = false, updatable = false)
	private LocalDateTime timestamp;
	
	
	
	
	
	
	
	
	
}
