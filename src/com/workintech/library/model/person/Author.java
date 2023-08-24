package com.workintech.library.model.person;

import com.workintech.library.model.book.Book;

import java.util.List;

public class Author extends Person{
    private List<Book> books;

    public Author(String name, String surname) {
        super(name, surname);
    }

    public Author(int id, String name, String surname, List<Book> books) {
        super(id, name, surname);
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "books=" + books +
                '}';
    }
}
