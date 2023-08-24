package com.workintech.library.model.book;

import com.workintech.library.model.person.Author;
import com.workintech.library.model.person.User;

import java.util.Objects;

public class Book implements Borrowable {
    private int bookId;
    private String title;
    private Category category;
    private Author author;
    private Status status;

    public Book(int bookId) {
        this.bookId = bookId;
    }

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public Book(String title, Category category, Author author) {
        this.title = title;
        this.category = category;
        this.author = author;
    }


    public Book(int bookId, String title, Category category, Author author, Status status) {
        this.bookId = bookId;
        this.title = title;
        this.category = category;
        this.author = author;
        this.status = status;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }

    @Override
    public boolean isAvailable() {
        return status == Status.AVAILABLE;
    }

    @Override
    public boolean canBorrow(User user) {
        return user.getBorrowedBooks().size() < 5 && isAvailable();
    }
}
