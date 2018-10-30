package com.ccsu.service;

import com.ccsu.domain.User;

public interface UserService {
    public boolean register(User user);

    public User login(String ue,String  password);

    public void updateUserAddress(User user);

    public void updatePwd(User user);
}
