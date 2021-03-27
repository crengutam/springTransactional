package com.example.springTransactional.datasource;


import com.example.springTransactional.model.User;

import java.util.List;

public interface UserDao {
    User find(long id);
    List<User> findAll();
    User create(User user);
    User update(User user);

    void delete(User user);

}
