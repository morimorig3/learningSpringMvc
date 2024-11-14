package com.learningApp.domain.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.learningApp.api.BookResource;
import com.learningApp.api.BookResourceQuery;

@Service
public class BookService {
	private final Map<String, BookResource> bookRepositoryMap = new ConcurrentHashMap<>();
	
	@PostConstruct
	public void loadDummyData() {
		BookResource bookResource = new BookResource();
		bookResource.setBookId("0000");
		bookResource.setName("書籍名");
		bookResource.setPublishDate(LocalDate.of(2024, 11, 11));
		bookRepositoryMap.put(bookResource.getBookId(), bookResource);
	}
	
	public BookResource find(String bookId) {
		BookResource bookResource = bookRepositoryMap.get(bookId);
		return bookResource;
	}
	
	public BookResource create(BookResource book) {
		String bookId = UUID.randomUUID().toString();
		book.setBookId(bookId);
		bookRepositoryMap.put(bookId, book);
		return book;
	}
	
	public BookResource update(BookResource book) {
		return bookRepositoryMap.put(book.getBookId(), book);
	}
	
	public BookResource delete(String bookId) {
		return bookRepositoryMap.remove(bookId);
	}
	
	public List<BookResource> findAllByQuery(BookResourceQuery query){
		return bookRepositoryMap.values().stream()
				.filter(book-> 
				(query.getName() == null 
					|| book.getName().contains(query.getName())) &&
				(query.getPublishDate() == null
						|| book.getPublishDate().equals(query.getPublishDate())))
				.sorted((o1, o2) ->
				o1.getPublishDate().compareTo(o2.getPublishDate()))
				.collect(Collectors.toList());
	}
}
