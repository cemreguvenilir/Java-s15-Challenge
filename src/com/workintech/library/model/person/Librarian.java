package com.workintech.library.model.person;

public class Librarian extends Person{
    private String email;
    private String password;
    private boolean hasPermission;

    public Librarian(String name, String surname) {
        super(name, surname);
    }

    public Librarian(int id, String name, String surname, String email, String password) {
        super(id, name, surname);
        this.email = email;
        this.password = password;
        this.hasPermission = true;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(boolean hasPermission) {
        this.hasPermission = hasPermission;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Librarian: " + getName() + " " + getSurname();
    }
}
