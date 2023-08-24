package com.workintech.library.model.person;

import com.workintech.library.model.book.Book;

import java.util.List;

public class User extends Person {
    private String email;
    private String password;
    private List<Book> borrowedBooks;

    public User(int id, String name, String surname, String email, String password, List<Book> borrowedBooks) {
        super(id, name, surname);
        this.email = email;
        this.password = password;
        this.borrowedBooks = borrowedBooks;

    }

    public User(String name, String surname) {
        super(name, surname);
    }

    public User(int id, String name, String surname, String email, String password) {
        super(id, name, surname);
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
