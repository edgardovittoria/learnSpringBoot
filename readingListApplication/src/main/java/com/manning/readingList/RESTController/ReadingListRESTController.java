package com.manning.readingList.RESTController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manning.readingList.domain.Book;
import com.manning.readingList.repository.ReadingListRepository;

@RestController
@RequestMapping("/rest")
public class ReadingListRESTController {
	
	@Autowired
	private ReadingListRepository readingListRepository;
	
	@GetMapping("/{reader}")
	public List<Book> getBook(@PathVariable("reader") String reader) {
		List<Book> readingList = readingListRepository.findByReader(reader);
		return readingList;
	}
	
	@PostMapping("/{reader}")
	public void addBook(@PathVariable("reader") String reader, @RequestBody Book book) {
		book.setReader(reader);
		readingListRepository.save(book);
	}
	
	@GetMapping("/books")
	public List<Book> getAllBook(){
		return readingListRepository.findAll();
	}
	
	@DeleteMapping("/delete/book/{bookId}")
	public void deleteBook(@PathVariable Long bookId) {
		readingListRepository.deleteById(bookId);
	}

}
