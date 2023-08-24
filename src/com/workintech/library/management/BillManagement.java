package com.workintech.library.management;

import com.workintech.library.model.book.Book;
import com.workintech.library.model.book.Status;
import com.workintech.library.model.person.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class BillManagement {
    private LocalDate borrowedDate;
    private LocalDate returnedDate;
    private Map<User, Map<Book, LocalDate>> borrowDates = new HashMap<>();
    private static final int maxBorrowedDays = 15;
    private static final double fee = 5.0;
    private static final double lateFeePerDay = 1.0;

    public LocalDate getBorrowDate() {
        return borrowedDate;
    }


    public LocalDate getReturnDate() {
        return returnedDate;
    }


    public double getFee() {
        return fee;
    }


    public static int calculateDaysBetween(LocalDate borrowDate, LocalDate returnDate) {
        return (int) ChronoUnit.DAYS.between(borrowDate, returnDate);
    }

    public static double calculateBill(LocalDate borrowDate, LocalDate returnDate){
        int borrowedDays = calculateDaysBetween(borrowDate, returnDate);
        if (borrowedDays <= maxBorrowedDays){
            return fee;
        } else {
            double lateFees = (borrowedDays - maxBorrowedDays) * lateFeePerDay;
            return fee + lateFees;
        }
    }
    public void borrowBook(User user, Book book) {

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
        borrowDates.computeIfAbsent(user, k -> new HashMap<>()).put(book, borrowDate);
        book.setStatus(Status.BORROWED);
        user.getBorrowedBooks().add(book);
        System.out.println("Book borrowed successfully.");

    }

    public void returnBook(User user, Book book) {
        if (book == null){
            System.out.println("Book not found.");
        }
        if(!user.getBorrowedBooks().contains(book)){
            System.out.println("You have not borrowed this book");
        }

        Map<Book, LocalDate> userBorrowDates = borrowDates.get(user);
        LocalDate borrowDate = userBorrowDates.get(book);
        calculateBill(borrowDate, LocalDate.now());
        book.setStatus(Status.AVAILABLE);
        user.getBorrowedBooks().remove(book);
        System.out.println("Book returned successfully");
    }

}
