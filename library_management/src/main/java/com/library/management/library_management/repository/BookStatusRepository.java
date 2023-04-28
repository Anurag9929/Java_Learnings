package com.library.management.library_management.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.library.management.library_management.entities.BookStatus;

public class BookStatusRepository {

//	List<BookStatus>bookStatuslist=new  ArrayList<BookStatus>();
	List<BookStatus> bookStatuslist;

	public BookStatusRepository() {
		bookStatuslist = new ArrayList<BookStatus>();

		BookStatus bookStatus = new BookStatus();
		bookStatus.setIssueId(20001);
		bookStatus.setIssueDate("27/04/2023");
		bookStatus.setBookId(10000001);
		bookStatus.setBookName("Computer Science");
		bookStatus.setIssuedFor("Anurag Shukla");
		bookStatus.setIssuedAddress("Ram Nagar,Coimbatore");
		bookStatus.setContactNo("7569875764");
		bookStatus.setReturnedDate(null);
		
		
		

		BookStatus bookStatus1 = new BookStatus();
		bookStatus1.setIssueId(20002);
		bookStatus1.setIssueDate("25/04/2023");
		bookStatus1.setBookId(10000002);
		bookStatus1.setBookName("History");
		bookStatus1.setIssuedFor("Sachin Singh");
		bookStatus1.setIssuedAddress("Ram Nagar,Coimbatore");
		bookStatus1.setContactNo("7569875764");
		bookStatus1.setReturnedDate("27/04/2023");

		bookStatuslist.add(bookStatus);
		bookStatuslist.add(bookStatus1);
	}

//Fetch/get:Operations
//fetch all by takenDate
	public List<BookStatus> getAllByTakenDate(String issueDate) {
		List<BookStatus> allBooks = new ArrayList<BookStatus>();
		for (BookStatus list : bookStatuslist) {
			if (list.getIssueDate() == issueDate) {
				allBooks.add(list);
			}
		}
		return allBooks;
	}

//fetch all by returnDate
	public List<BookStatus> getByReturnDate(String returnDate) {
		List<BookStatus> allBooks = new ArrayList<BookStatus>();
		for (BookStatus list : bookStatuslist) {
			if (list.getReturnedDate() == returnDate) {
				allBooks.add(list);
			}
		}
		return allBooks;
	}

//fetch all the issue books.
	public List<BookStatus> getAllBooks() {
		return bookStatuslist;
	}

//fetch by issueId.
	public BookStatus getByIssueId(int issueId) {
		for (BookStatus list : bookStatuslist) {
			if (list.getIssueId() == issueId) {
				return list;
			}
		}
		return new BookStatus();
	}

//fetch by bookId.
	public BookStatus getByBookId(int bookId) {
		for (BookStatus list : bookStatuslist) {
			if (list.getBookId() == bookId) {
				return list;
			}
		}
		return new BookStatus();
	}

//Create:when a new book is getting issued,entry made here and booklist also updated
	public List<BookStatus> createBookStatusEntry(BookStatus bookStatus) {
		boolean added = bookStatuslist.add(bookStatus);
		if (added) {
			return bookStatuslist;
		} else {
			return bookStatuslist;
		}

	}

//Update: only returndate can be updated and booklist will also update
	public List<BookStatus> updateEntry(int issueId, String returnDate) {
		for (BookStatus bookStatus : bookStatuslist) {
			if (bookStatus.getIssueId() == issueId) {
				bookStatus.setReturnedDate(new Date().toString());
//				bookStatuslist.add(bookStatuslist.indexOf(bookStatus), bookStatus);
				bookStatuslist.set(bookStatuslist.indexOf(bookStatus), bookStatus);
				return bookStatuslist;
			}

		}
		return bookStatuslist;

	}

//Delete:will delete the entry	
	public List<BookStatus> deleteBookEntry(int issueId) {
		String msg = null;
		for (BookStatus book : bookStatuslist) {
			if (book.getIssueId() == issueId) {
//				bookStatuslist.remove(issueId);
				bookStatuslist.remove(bookStatuslist.indexOf(book));
				msg = "Deleted";
				return bookStatuslist;
			}
			msg = "Id Not present";
		}
		return bookStatuslist;

	}

}
