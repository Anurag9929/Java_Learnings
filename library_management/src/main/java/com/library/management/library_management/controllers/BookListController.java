package com.library.management.library_management.controllers;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.library.management.library_management.entities.BookList;
import com.library.management.library_management.repository.BookListRepository;


@Path("/booksList")
public class BookListController {

	
	
	BookListRepository bookListRepository=new BookListRepository();
	
//	get/fetch
//	1:get All available books
	@GET
	@Path("/allBooks")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<BookList>allBooks(){
		return bookListRepository.allBooks();
	}
	
	
//	2:fetch by Id
	@GET
	@Path("/bookById/{bookId}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public BookList bookById(@PathParam("bookId")int bookId){
		return bookListRepository.bookById(bookId);
	}
	
//	2:fetch by bookName
	@GET
	@Path("/bookByBookName/{bookName}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public BookList bookByBookName(@PathParam("bookName")String bookName){
		return bookListRepository.getByBookName(bookName);
	}
	
	
//	2:fetch by authorName
	@GET
	@Path("/bookByAuthorName/{authorName}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public BookList bookByAuthorName(@PathParam("authorName")String authorName){
		return bookListRepository.getByAuthorName(authorName);
	}
	
	
//	post
	@POST
	@Path("/createbooklist")
	public List<BookList> createBookList(BookList bookList) {
		  List<BookList> createBookList = bookListRepository.createBookList(bookList);
		return createBookList;
//	return (List<BookList>) Response.status(200).entity(booksList).build();
		
	}
//	update
	@PUT
	@Path("/update/{bookId}")
	public List<BookList> updateBookList(@PathParam("bookId") int bookId) {
		List<BookList> updateBookById = bookListRepository.updateBookById(bookId);
		return updateBookById;
	}
	
//	delete
	@DELETE
	@Path("/delete/{bookId}")
	public List<BookList> deleteBook(@PathParam("bookId")int bookId) {
	    List<BookList> deleteBookbyId = bookListRepository.deleteBookbyId(bookId);
	    return  deleteBookbyId;
	}
}
