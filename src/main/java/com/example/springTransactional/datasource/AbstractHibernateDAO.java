package com.example.springTransactional.datasource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractHibernateDAO<T>{
    private Class<T> clazz;

    @Autowired
    private SessionFactory sessionFactory;

    public void setClazz(Class<T> clazzToSet) {
        clazz = clazzToSet;
    }

    public T find(long id) {
        return (T) getCurrentSession().get( clazz, id );
    }
    public List<T> findAll() {
        return getCurrentSession()
                .createQuery( "from " + clazz.getName() ).list();
    }

    public T create(final T entity) {
        getCurrentSession().save(entity);
        return entity;
    }

    public T update(T entity) {
        return (T) getCurrentSession().merge( entity );
    }

    public void delete(T entity) {
        getCurrentSession().delete( entity );
    }

    protected final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}
