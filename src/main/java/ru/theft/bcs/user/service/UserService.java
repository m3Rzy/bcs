package ru.theft.bcs.user.service;


import ru.theft.bcs.user.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(Long id);

    User add(User user);

    void delete(User user);
}
