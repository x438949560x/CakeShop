package com.ccsu.dao.impl;

import com.ccsu.dao.UserDao;
import com.ccsu.domain.User;
import com.ccsu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private DataSource ds = JDBCUtils.getDataSource();
    private QueryRunner r = new QueryRunner(ds);

    @Override
    public void addUser(User user) throws SQLException {
        String sql = "insert into user(username,email,password,name,phone,address,isadmin,isvalidate) values(?,?,?,?,?,?,?,?)";
        r.update(sql, user.getUsername(),user.getEmail(),user.getPassword(),user.getName(),user.getPhone(),user.getAddress(),user.isIsadmin(),user.isIsvalidate());
    }

    @Override
    public boolean isUsernameExist(String username) throws SQLException {
        String sql = "select * from user where username = ?";
        User u = r.query(sql, new BeanHandler<User>(User.class), username);
        if(u==null){
            return false;
        }
        return true;
    }

    @Override
    public boolean isEmailExist(String email) throws SQLException {
        String sql = "select * from user where email = ?";
        User u = r.query(sql, new BeanHandler<User>(User.class), email);
        if(u==null){
            return false;
        }
        return true;
    }

    @Override
    public User selectByUsernamePassword(String usernmae, String password) throws SQLException {
        String sql = "select * from user where username=? and password=?";
        return r.query(sql, new BeanHandler<User>(User.class), usernmae, password);
    }

    @Override
    public User selectByEmailPassword(String email, String password) throws SQLException {
        String sql = "select * from user where email=? and password=?";
        return r.query(sql, new BeanHandler<User>(User.class), email, password);
    }

    @Override
    public void updateUserAddress(User user) throws SQLException {
        String sql = "update user set name=?,phone = ?,address= ? where id = ?";
        r.update(sql, user.getName(), user.getPhone(), user.getAddress(), user.getId());
    }

    @Override
    public void updatePwd(User user) throws SQLException {
        String sql = "update user set password=? where id = ?";
        r.update(sql, user.getPassword(), user.getId());
    }
}
