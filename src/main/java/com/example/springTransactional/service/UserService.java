package com.example.springTransactional.service;

import com.example.springTransactional.datasource.UserDao;
import com.example.springTransactional.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void createUser(User user){
        userDao.create(user);
    }

    @Transactional
    public void deleteUser(User user){
        System.out.println("Deleting user "+ user);
        userDao.delete(user);
    }

    @Transactional
    public List<User> getAllUsers(){
        return userDao.findAll();
    }

    @Transactional
    public void createUserDeclarativeWithRuntimeException(User user) {
        userDao.create(user);
        throw new DataIntegrityViolationException("Throwing exception for demoing Rollback!!!");
    }

    @Transactional(rollbackFor = { SQLException.class })
    public void createUserDeclarativeWithCheckedException(User user) throws SQLException {
        userDao.create(user);
        throw new SQLException("Throwing exception for demoing Rollback!!!");
    }

    @Transactional(noRollbackFor = { SQLException.class })
    public void createUserDeclarativeWithNoRollBack(User user) throws SQLException {
        userDao.create(user);
        throw new SQLException("Throwing exception for demoing Rollback!!!");
    }

}

