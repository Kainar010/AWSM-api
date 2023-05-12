package me.kainar.awsm.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import me.kainar.awsm.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class UserDAO {

    private SessionFactory sessionFactory;

    public void addUser(User user){
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }


    public void updateUser(User user){
        Session session = sessionFactory.getCurrentSession();
        session.merge(user);
    }

    public void deleteUser(User user){
        Session session = sessionFactory.getCurrentSession();
        session.remove(user);
    }

    public User getUserById(Long id){
        Session session = sessionFactory.getCurrentSession();
        return (User)session.get(User.class, id);
    }

    public User getUserByUsername(String username){
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("FROM User WHERE userName = :username", User.class);
        query.setParameter("username", username);
        return query.uniqueResult();
    }


    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
