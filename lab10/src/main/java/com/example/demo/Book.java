package com.example.demo;

public class Book {
int bookid;
String author, year, title;
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
@Override
public String toString() {
	return "Book [bookid=" + bookid + ", author=" + author + ", year=" + year + ", title=" + title + "]";
}



}
