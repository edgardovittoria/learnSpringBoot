package com.manning.readingList.controller;

import java.util.Collection;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manning.readingList.domain.Book;
import com.manning.readingList.domain.Reader;
import com.manning.readingList.repository.ReaderRepository;
import com.manning.readingList.repository.ReadingListRepository;

@Controller
@RequestMapping("/")
public class ReadingListController {
	
	private ReadingListRepository readingListRepository;
	
	private ReaderRepository readerRepository;
	
	@Autowired
	public ReadingListController(ReadingListRepository readingListRepository) {
		this.readingListRepository = readingListRepository;
	}
	
	@RequestMapping(value="/{reader}", method=RequestMethod.GET)
	public String readersBooks(@PathVariable("reader") String reader, Model model) {
		List<Book> readingList = readingListRepository.findByReader(reader);
		if(readingList != null) {
			model.addAttribute("books", readingList);
		}
		return "readingList";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage(Model model) {
		 return "login";
    }
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestAttribute("username") String username , @RequestAttribute("password") String password) {
		UserDetails user = readerRepository.findByUsername(username);
		//Collection<? extends GrantedAuthority> role = user.getAuthorities();
		
		 if(user.getUsername() == username && user.getPassword() == password) {
			 return "readingList";
		 }
		 else {
			 Reader reader = new Reader();
			 reader.setUsername(username);
			 reader.setPassword(password);
			 readerRepository.save(reader);
		 }
		return "readingList";
    }

	
	@RequestMapping(value="/{reader}", method=RequestMethod.POST)
	public String addToReadingList(@PathVariable("reader") String reader, Book book) {
		book.setReader(reader);
		readingListRepository.save(book);
		return "redirect:/{reader}";
	}
	


}
