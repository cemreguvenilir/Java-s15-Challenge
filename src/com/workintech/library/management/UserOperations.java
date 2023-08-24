package com.workintech.library.management;

import com.workintech.library.model.person.User;

public interface UserOperations {
    void addUser(User user);
    void updateUser(int id, User user);
    void removeUser(int id);
}
