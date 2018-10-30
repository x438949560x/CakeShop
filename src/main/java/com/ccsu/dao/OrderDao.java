package com.ccsu.dao;

import com.ccsu.domain.Order;
import com.ccsu.domain.OrderItem;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    public int insertOrder(Connection conn, Order order) throws SQLException;

    public void insertOrderItem(Connection conn, OrderItem item) throws  SQLException;

    public List<Order> selectAll(int userid) throws SQLException;

    public List<OrderItem> selectAllItem(int orderid) throws SQLException;
}
