package com.library.management.library_management.controllers;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.library.management.library_management.entities.BookStatus;
import com.library.management.library_management.repository.BookStatusRepository;

@Path("/bookStatus")
public class BookStatusController {

	BookStatusRepository bookStatusRepository = new BookStatusRepository();

	@GET
	@Path("/byIssueId/{issueId}")
	public BookStatus getByIssueId(@PathParam("issueId") int issueId) {
		return bookStatusRepository.getByIssueId(issueId);

	}

	@GET
	@Path("/byBookId/{bookId}")
	public BookStatus getByBookId(@PathParam("bookId") int bookId) {
		return bookStatusRepository.getByBookId(bookId);

	}

//	all by takenDate
	@GET
	@Path("/byTakenDate/{takenDate}")
	public List<BookStatus> getByTakenDate(@PathParam("takenDate") String takenDate) {
		List<BookStatus> allByTakenDate = bookStatusRepository.getAllByTakenDate(takenDate);
		return allByTakenDate;

	}

//	all By ReturnDate
	@GET
	@Path("/byReturnDate/{returnDate}")
	public List<BookStatus> getByReturnDate(@PathParam("returnDate") String returnDate) {
		return bookStatusRepository.getByReturnDate(returnDate);
   }

//	getAll
	@GET
	@Path("/all")
	public List<BookStatus> getAll() {
		return bookStatusRepository.getAllBooks();
	}

//deleteById	
	@DELETE
	@Path("/deletebyId/{issueId}")
	public List<BookStatus> deleteById(@PathParam("issueId") int issueId) {
		return bookStatusRepository.deleteBookEntry(issueId);

	}

//update
	@PUT
	@Path("/update/{issueId}")
	public List<BookStatus> updateById(@PathParam("issueId") int issueId, String returnDate) {
		List<BookStatus> updateEntry = bookStatusRepository.updateEntry(issueId, returnDate);
		return updateEntry;
	}

//create
	@POST
	@Path("/create")
	public List<BookStatus> createBookStatus(BookStatus bookStatus) {
		return bookStatusRepository.createBookStatusEntry(bookStatus);
	}

}
