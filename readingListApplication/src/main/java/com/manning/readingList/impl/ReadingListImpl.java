/*package com.manning.readingList.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manning.readingList.domain.Book;
import com.manning.readingList.repository.ReadingListRepository;
import com.manning.readingList.business.BusinessException;
import com.manning.readingList.business.ReadingListService;


@Service
@Transactional
public class ReadingListImpl implements ReadingListService{
	
	@Autowired
	private ReadingListRepository readingListRepository;
	
	@Override
	public void storeBook(Book book) throws BusinessException {
		readingListRepository.save(book);
	}
}
*/