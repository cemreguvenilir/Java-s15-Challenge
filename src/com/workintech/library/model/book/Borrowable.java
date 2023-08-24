package com.workintech.library.model.book;

import com.workintech.library.model.person.User;

public interface Borrowable {
    boolean isAvailable();
    boolean canBorrow(User user);
}
