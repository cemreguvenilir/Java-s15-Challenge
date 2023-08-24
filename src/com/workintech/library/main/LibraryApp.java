package com.workintech.library.main;

import com.workintech.library.management.BillManagement;
import com.workintech.library.management.BookManagement;
import com.workintech.library.management.UserManagement;
import com.workintech.library.model.book.Book;
import com.workintech.library.model.book.Category;
import com.workintech.library.model.book.Status;
import com.workintech.library.model.person.Author;
import com.workintech.library.model.person.Librarian;
import com.workintech.library.model.person.User;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class LibraryApp {
    public static void main(String[] args) {


        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        UserManagement userManagement = new UserManagement();
        User user1 = new User(1, "ali", "veli", "aliveli@gmail.com", "1234");
        userManagement.addUser(user1);
        Librarian librarian1 = new Librarian(1, "cemre", "güvenilir", "guvenilircemre@gmail.com", "1234");
        userManagement.addLibrarian(librarian1);
        BookManagement bookManagement = new BookManagement();
        Book bookExample = new Book("Martin Eden", Category.NOVEL, new Author("Jack", "London"));
        Book bookExample2 = new Book("Tutunamayanlar", Category.NOVEL, new Author("Oğuz", "Atay"));
        bookManagement.addBook(librarian1, bookExample);
        bookManagement.addBook(librarian1, bookExample2);
        List<Book> books = new ArrayList<>();
        books.add(bookExample.getBookId(),bookExample);
        books.add(bookExample2.getBookId(), bookExample2);
        BillManagement billManagement = new BillManagement();
        System.out.println("Welcome to the Library App!");

        while(true){
            System.out.println("Select user type:");
            System.out.println("1.Librarian");
            System.out.println("2.User");
            System.out.println("3.Exit");
            int userTypeChoice = scanner.nextInt();
            scanner.nextLine();

            if (userTypeChoice == 3){
                System.out.println("Exiting");
                break;
            }

            System.out.println("Enter email");
            String email = scanner.next();
            System.out.println("Enter your password");
            String password = scanner.next();


            if(userTypeChoice == 1){
                Librarian librarian = userManagement.authenticateLibrarian(email, password);
                if(librarian !=null){
                    System.out.println("Welcome, Librarian!");
                    System.out.println("1. Add book");
                    System.out.println("2. Update book");
                    System.out.println("3. Delete book");
                    System.out.println("4. Lists books");
                    System.out.println("5. Exit");
                    System.out.println("Please enter your choice: ");
                    int librarianChoice = scanner.nextInt();
                    scanner.nextLine();


                    switch(librarianChoice){
                        case 1:
                            System.out.println("Enter book title");
                            String title = scanner.nextLine();
                            System.out.println("Enter book category : NOVEL, STORY, PHILOSOPHY, HISTORY, BIOGRAPHY, SCIENCE_FICTION");
                            Category category = Category.valueOf(scanner.nextLine().toUpperCase());
                            System.out.println("Please enter author name");
                            String authorName = scanner.nextLine();
                            System.out.println("Please enter author surname");
                            String authorSurname = scanner.nextLine();
                            Author author = new Author(authorName, authorSurname);
                            Book book = new Book(title, category, author);
                            bookManagement.addBook(librarian, book);
                            System.out.println("added successfully");
                            break;
                        case 2:
                            System.out.println("Enter book title");
                            String title2 = scanner.nextLine();
                            System.out.println("Enter book category : NOVEL, STORY, PHILOSOPHY, HISTORY, BIOGRAPHY, SCIENCE_FICTION");
                            Category category2 = Category.valueOf(scanner.nextLine().toUpperCase());
                            System.out.println("Please enter author name");
                            String authorName2 = scanner.nextLine();
                            System.out.println("Please enter author surname");
                            String authorSurname2 = scanner.nextLine();
                            Author author2 = new Author(authorName2, authorSurname2);
                            Book book2 = new Book(title2, category2, author2);
                            bookManagement.updateBook(librarian, book2);
                            break;
                        case 3:
                            System.out.println("Please enter book id");
                            int bookId = scanner.nextInt();
                            bookManagement.removeBook(librarian,bookId);
                            break;
                        case 4:
                            List<Book> allBooks = bookManagement.getAllBooks();
                            if(allBooks.isEmpty()){
                                System.out.println("there is no book");
                            }
                            System.out.println("books: ");
                            for (Book b: allBooks){
                                System.out.println(b);
                            }
                            break;
                        case 5:
                            System.out.println("Exiting..");
                            System.exit(5);
                        default:
                            System.out.println("Invalid choice");
                    }

                } else {
                    System.out.println("Librarian authentication failed.");
                }
            }
                else if (userTypeChoice == 2){
                    User user = userManagement.authenticateUser(email, password);
                    if(user != null){
                        System.out.println("Welcome, user!");
                        System.out.println("1. List books by title");
                        System.out.println("2. List books by author");
                        System.out.println("3. List books by category");
                        System.out.println("4. Borrow book");
                        System.out.println("5. Return book");
                        System.out.println("6. Exit");
                        System.out.println("Enter your choice ");
                        int userChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch(userChoice){
                            case 1:
                                System.out.println("Please enter book title");
                                String title = scanner.nextLine();
                                System.out.println(bookManagement.getBooksByTitle(title));
                               break;
                            case 2:
                                System.out.println("Please enter author name");
                                String authorName = scanner.nextLine();
                                System.out.println("Please enter author surname");
                                String authorSurname = scanner.nextLine();
                                Author author = new Author(authorName, authorSurname);
                                bookManagement.getBooksByAuthor(author);
                                break;
                            case 3:
                                System.out.println("Enter book category : NOVEL, STORY, PHILOSOPHY, HISTORY, BIOGRAPHY, SCIENCE_FICTION");
                                Category category = Category.valueOf(scanner.nextLine().toUpperCase());
                                bookManagement.getBooksByCategory(category);
                                break;
                            case 4:
                                System.out.println("Enter book title");
                                String title3 = scanner.nextLine();
                                System.out.println("Please enter author name");
                                String authorName3 = scanner.nextLine();
                                System.out.println("Please enter author surname");
                                String authorSurname3 = scanner.nextLine();
                                Author author3 = new Author(authorName3, authorSurname3);
                                Book book3 = new Book(title3, author3);
                                billManagement.borrowBook(user, book3);
                                break;
                            case 5:
                                System.out.println("Enter your book Id");
                                int bookId = scanner.nextInt();
                                Book book4 = new Book(bookId);
                                billManagement.returnBook(user, book4);
                                break;
                            case 6:
                                System.out.println("Exiting..");
                                System.exit(6);
                            default:
                                System.out.println("Invalid choice");
                        }

                    } else {
                        System.out.println("User authentication failed");
                    }
                }
                else {
                    System.out.println("Invalid choice, please enter 1 or 2");
                }
            }
        }

    }
