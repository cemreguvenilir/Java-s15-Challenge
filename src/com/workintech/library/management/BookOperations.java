package com.workintech.library.management;

import com.workintech.library.model.book.Book;
import com.workintech.library.model.book.Category;
import com.workintech.library.model.person.Author;
import com.workintech.library.model.person.Librarian;
import com.workintech.library.model.person.User;

import java.util.List;

public interface BookOperations {
    void addBook(Librarian librarian, Book book);
    void updateBook(Librarian librarian, Book book);
    void removeBook(Librarian librarian, int bookId);
   // void borrowBook(User user, int bookId);
   // void returnBook(User user, int bookId);
    List<Book> getAllBooks();
    List<Book> getBooksByTitle(String title);
    List<Book> getBooksByAuthor(Author author);
    List<Book> getBooksByCategory(Category category);
    Book getBooksById(int bookId);


}
