package com.workintech.library.management;

import com.workintech.library.model.person.Librarian;
import com.workintech.library.model.person.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManagement implements UserOperations {
    private static Map<Integer, User> users;
    private static Map<Integer, Librarian> librarians;

    public UserManagement() {
        this.users = new HashMap<>();
        this.librarians = new HashMap<>();
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Integer, User> users) {
        this.users = users;
    }

    public static Map<Integer, Librarian> getLibrarians() {
        return librarians;
    }

    public static void setLibrarians(Map<Integer, Librarian> librarians) {
        UserManagement.librarians = librarians;
    }

    @Override
    public void addUser(User user) {
        if (users.containsKey(user.getId())){
            System.out.println("the user already exists.");
        }
        users.put(user.getId(), user);
        System.out.println("User added successfully.");
    }

    @Override
    public void updateUser(int id, User user) {
        if(users.containsKey(id)){
            users.put(id, user);
            System.out.println("User updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    @Override
    public void removeUser(int id) {
        if(users.containsKey(id)){
            users.remove(id);
            System.out.println("User removed successfully.");
        } else {
            System.out.println("User not found.");
        }
    }
    public void addLibrarian(Librarian librarian){
        if(librarians.containsKey(librarian.getId())){
            System.out.println("the librarian is already exists");
        }
        librarians.put(librarian.getId(), librarian);
        System.out.println("added successfully");
    }
    public User authenticateUser(String email, String password) {
        for (User user : users.values()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
    public Librarian authenticateLibrarian(String email, String password) {
        for (Librarian librarian : librarians.values()) {
            if (librarian.getEmail().equals(email) && librarian.getPassword().equals(password)) {
                return librarian;
            }
        }
        return null;
    }
}
