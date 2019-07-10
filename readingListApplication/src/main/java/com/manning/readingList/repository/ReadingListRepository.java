package com.manning.readingList.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.manning.readingList.domain.Book;


public interface ReadingListRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByReader(String reader);
	//void storeBook(Book book);
}