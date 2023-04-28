package com.library.management.library_management.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookList {
	
	private int bookId;
	private String bookName;
	private String authorName;
	private String status;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BookList [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", status="
				+ status + "]";
	}
	public BookList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookList(int bookId, String bookName, String authorName, String status) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.status = status;
	}
	
	
	

}
