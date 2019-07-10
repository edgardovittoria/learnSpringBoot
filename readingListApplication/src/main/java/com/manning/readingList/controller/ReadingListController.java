package com.manning.readingList.controller;

import java.util.Collection;
import java.util.List;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manning.readingList.domain.Book;
import com.manning.readingList.domain.User;
import com.manning.readingList.repository.ReadingListRepository;

import ch.qos.logback.core.net.LoginAuthenticator;

@Controller
@RequestMapping("/rest")
public class ReadingListController {
	
	private ReadingListRepository readingListRepository;
	
	
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


	
	@RequestMapping(value="/{reader}", method=RequestMethod.POST)
	public String addToReadingList(@PathVariable("reader") String reader, Book book) {
		book.setReader(reader);
		readingListRepository.save(book);
		return "redirect:/rest/{reader}";
	}
	

	


}
