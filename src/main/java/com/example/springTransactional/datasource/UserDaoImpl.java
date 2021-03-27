package com.example.springTransactional.datasource;

import com.example.springTransactional.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractHibernateDAO<User> implements UserDao{
    public UserDaoImpl() {
        super();
        setClazz(User.class);
    }
}
