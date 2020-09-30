package com.radke.farmersmarketapp.Services;

import com.radke.farmersmarketapp.DAO.UserDAO;
import com.radke.farmersmarketapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User saveNewUser(User user) {
        User saveTrue = userDAO.saveNewUser(user);
        return saveTrue;
    }

}
