package com.learningApp.api;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.learningApp.domain.service.BookService;

@RestController
@RequestMapping("books")
public class BooksRestController {

	@Autowired
	BookService bookService;
	
	@GetMapping(path = "{bookId}")
	public BookResource getBook(@PathVariable String bookId) {
		
		BookResource book = bookService.find(bookId);
		
		if(book == null) {
			throw new BookResourceNotFoundException(bookId);
		}
		
		BookResource bookResource = new BookResource();
		bookResource.setBookId(book.getBookId());
		bookResource.setName(book.getName());
		bookResource.setPublishDate(book.getPublishDate());
		
		return bookResource;
	}
	
	@PostMapping
	public ResponseEntity<Void> createBook(
			@Validated @RequestBody BookResource newResource,
			UriComponentsBuilder uriComponentsBuilder
			){
		BookResource newBook= new BookResource();
		newBook.setName(newResource.getName());
		newBook.setPublishDate(newResource.getPublishDate());
		
		BookResource createdBookResource = bookService.create(newBook);
		
		URI resourceUri = MvcUriComponentsBuilder.relativeTo(uriComponentsBuilder)
				.withMethodCall(
						MvcUriComponentsBuilder.on(BooksRestController.class).getBook(createdBookResource.getBookId())
						).build().encode().toUri();
		
		return ResponseEntity.created(resourceUri).build();
	}
	
	@PutMapping(path = "{bookId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void put(@PathVariable String bookId,@Validated @RequestBody BookResource resource) {
		BookResource book = new BookResource();
		book.setBookId(bookId);
		book.setName(resource.getName());
		book.setPublishDate(resource.getPublishDate());
		bookService.update(book);
		}
	
	@DeleteMapping(path = "{bookId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void put(@PathVariable String bookId) {
		bookService.delete(bookId);
		}
	
	@GetMapping
	public List<BookResource> searchBooks(@Validated BookResourceQuery query){
		List<BookResource>  books = bookService.findAllByQuery(query);
		return books.stream().map(book ->{
			BookResource resource = new BookResource();
			resource.setBookId(book.getBookId());
			resource.setName(book.getName());
			resource.setPublishDate(book.getPublishDate());
			return resource;
		}).collect(Collectors.toList());
	}
}
