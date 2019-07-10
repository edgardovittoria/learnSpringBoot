package com.manning.readingList.business;

import com.manning.readingList.domain.Book;

public interface ReadingListService {

	void storeBook(Book book) throws BusinessException;

}
