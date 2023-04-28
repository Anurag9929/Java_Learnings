package com.library.management.library_management.repository;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.Response;

import com.library.management.library_management.entities.BookList;


public class BookListRepository {

//	List<BookList> booksList = new ArrayList<BookList>();
	List<BookList> booksList;

	public BookListRepository() {
//		method 1: Also process working but updates/data not holding(don't know why)
//		booksList = new ArrayList<BookList>();
//		
//		BookList book1 = new BookList();
//		book1.setBookId(10000001);
//		book1.setBookName("Computer Science");
//		book1.setAuthorName("M.R.K.Rao");
//		book1.setStatus("Available");
//
//		BookList book2 = new BookList();
//		book2.setBookId(10000002);
//		book2.setBookName("History");
//		book2.setAuthorName("Bishal");
//		book2.setStatus("Available");
//
//		BookList book3 = new BookList();
//		book3.setBookId(10000003);
//		book3.setBookName("English");
//		book3.setAuthorName("Arjun");
//		book3.setStatus("Available");
//
//		BookList book4 = new BookList();
//		book4.setBookId(10000004);
//		book4.setBookName("Maths");
//		book4.setAuthorName("Rahul S. Pal");
//		book4.setStatus("Available");
//
//		BookList book5 = new BookList();
//		book5.setBookId(10000005);
//		book5.setBookName("Social Science");
//		book5.setAuthorName("Viraj Singh");
//		book5.setStatus("Available");
//		
//		booksList.add(book1);
//		booksList.add(book2);
//		booksList.add(book3);
//		booksList.add(book4);
//		booksList.add(book5);
		
//		method 1:

//		booksList = new ArrayList<BookList>();
//		
//			booksList.add(new BookList(10000001,"Computer Science","M.R.K.Rao","Available"));
//			booksList.add(new BookList(10000002,"History","Suman","Available"));
//			booksList.add(new BookList(10000003,"English","Arjun","Available"));
//			booksList.add(new BookList(10000004,"Maths","Rahul S. Pal","Available"));
//			booksList.add(new BookList(10000005,"Social Science","Viraj Singh","Available"));
//
//	
			
		booksList = Collections.synchronizedList(new ArrayList());
		    
		synchronized (booksList) {
		    Iterator i = booksList.iterator(); // Must be in synchronized block
		    while (i.hasNext())
//		        foo(i.next());
				booksList.add(new BookList(10000001,"Computer Science","M.R.K.Rao","Available"));
				booksList.add(new BookList(10000002,"History","Suman","Available"));
				booksList.add(new BookList(10000003,"English","Arjun","Available"));
				booksList.add(new BookList(10000004,"Maths","Rahul S. Pal","Available"));
				booksList.add(new BookList(10000005,"Social Science","Viraj Singh","Available"));
	
		}

		
		
	}

//get/fetch:
//	fetch by Id.
	public BookList bookById(int bookId) {
		for (BookList list : booksList) {
			if (list.getBookId() == bookId && list.getStatus() == "Available") {
				return list;
			}
		}
		return new BookList();
	}

//	fetch all available books.
	public List<BookList> allBooks() {
		return booksList;
	}

//	fetch by bookName.
	public BookList getByBookName(String bookName) {
		for (BookList list : booksList) {
			if (list.getBookName().equalsIgnoreCase(bookName)) {
				return list;
			}
		}
		return new BookList();
	}

//	fetch by authorName.
	public BookList getByAuthorName(String authorName) {
		for (BookList list : booksList) {
			if (list.getAuthorName().equalsIgnoreCase(authorName)) {
				return list;
			}
		}
		return new BookList();
	}

//update
	public List<BookList> updateBookById(int bookId) {
		String msg = "Not Found";
		for (BookList list : booksList) {
			if (list.getBookId() == bookId) {
				list.setStatus("Unavailable");
				msg = "Successfully Updated";
				return booksList;
			}
		}
//			return msg;
		return (List<BookList>) new BookList();
	}

//create:
	public List<BookList> createBookList(BookList bookList) {
		boolean added = booksList.add(bookList);
		if (added) {
			return booksList;
//			return (List<BookList>) Response.status(200).entity(booksList).build();

		}
		return booksList;

	}

//delete:
	public List<BookList> deleteBookbyId(int bookId) {
		String msg = null;
		for (BookList bookList : booksList) {
			if (bookList.getBookId() == bookId) {
				int index_value = booksList.indexOf(bookList);
				booksList.remove(index_value);
				msg = "Deleted Successfully";
				return booksList;
			}
		}
		return (List<BookList>) new BookList();
	}

}
