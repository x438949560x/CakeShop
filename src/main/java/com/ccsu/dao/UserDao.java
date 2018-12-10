package com.ccsu.dao;

import com.ccsu.domain.User;

import java.sql.SQLException;

public interface UserDao {
    public void addUser(User user) throws SQLException;

    public boolean isUsernameExist(String username) throws SQLException;

    public boolean isEmailExist(String email) throws SQLException;

    public User selectByUsernamePassword(String usernmae, String password) throws SQLException;

    public User selectByEmailPassword(String email, String password) throws SQLException;

    public void updateUserAddress(User user) throws SQLException;

    public void updatePwd(User user) throws SQLException;
}
