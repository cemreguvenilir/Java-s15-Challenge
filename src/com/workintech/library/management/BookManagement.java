package com.workintech.library.management;

import com.workintech.library.model.book.Book;
import com.workintech.library.model.book.Category;
import com.workintech.library.model.book.Status;
import com.workintech.library.model.person.Author;
import com.workintech.library.model.person.Librarian;
import com.workintech.library.model.person.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookManagement implements BookOperations{
    private Map<Integer, Book> books;
    private Map<User, List<Book>> borrowedBooks;

    public BookManagement() {
        this.books = new HashMap<>();
        this.borrowedBooks = new HashMap<>();
    }

    public Map<User, List<Book>> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Map<User, List<Book>> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public void addBook(Librarian librarian, Book book) {
        if (librarian.isHasPermission()) {
            books.put(book.getBookId(), book);
        } else {
            System.out.println("You don't have permission to add books.");
        }

    }

    @Override
    public void updateBook(Librarian librarian, Book book) {
        if (librarian.isHasPermission()) {
            books.put(book.getBookId(), book);
        } else {
            System.out.println("You don't have permission to update books.");
        }
    }

    @Override
    public void removeBook(Librarian librarian, int bookId) {
        if (librarian.isHasPermission()) {
            books.remove(bookId);
        } else {
            System.out.println("You don't have permission to remove books.");
        }
    }

   /* @Override
    public void borrowBook(User user, int bookId) {
        Book book = getBooksById(bookId);
        if (book == null){
            System.out.println("Book not found.");
        }
        if (!book.isAvailable()){
            System.out.println("Book is not available for borrowing.");
        }
        if (user.getBorrowedBooks().size()>=5){
            System.out.println("You have reached the borrowing limit.");
        }
        LocalDate borrowDate = LocalDate.now();

        book.setStatus(Status.BORROWED);
        user.getBorrowedBooks().add(book);
        System.out.println("Book borrowed successfully.");

    }

    @Override
    public void returnBook(User user, int bookId) {
        Book book = getBooksById(bookId);
        if (book == null){
            System.out.println("Book not found.");
        }
        if(!user.getBorrowedBooks().contains(book)){
            System.out.println("You have not borrowed this book");
        }
        book.setStatus(Status.AVAILABLE);
        user.getBorrowedBooks().remove(book);
        System.out.println("Book returned successfully");
    } */

    @Override
    public List<Book> getAllBooks() {
        return books.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return books.values().stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return books.values().stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksByCategory(Category category) {
        return books.values().stream().filter(book -> book.getCategory().equals(category)).collect(Collectors.toList());
    }

    @Override
    public Book getBooksById(int bookId) {
        return books.get(bookId);
    }
}
