package com.ccsu.service.impl;

import com.ccsu.dao.UserDao;
import com.ccsu.dao.impl.UserDaoImpl;
import com.ccsu.domain.User;
import com.ccsu.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean register(User user) {
        try {
            if(userDao.isUsernameExist(user.getUsername()) || userDao.isEmailExist(user.getEmail())) {
                return false;
            }
            userDao.addUser(user);
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User login(String ue,String  password) {
        try {
            User user = userDao.selectByUsernamePassword(ue, password);
            if(user!=null){
                return user;
            }
            user = userDao.selectByEmailPassword(ue, password);
            if(user!=null){
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUserAddress(User user) {
        try{
            userDao.updateUserAddress(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePwd(User user) {
        try{
            userDao.updatePwd(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
