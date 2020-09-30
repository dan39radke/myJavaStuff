package com.radke.farmersmarketapp.DAO;

import com.radke.farmersmarketapp.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public User saveNewUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return user;
    }


}
