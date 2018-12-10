package com.ccsu.service.impl;

import com.ccsu.dao.OrderDao;
import com.ccsu.dao.impl.OrderDaoImpl;
import com.ccsu.domain.Order;
import com.ccsu.domain.OrderItem;
import com.ccsu.domain.Page;
import com.ccsu.service.OrderService;
import com.ccsu.utils.JDBCUtils;
import com.sun.tools.corba.se.idl.constExpr.Or;

import java.beans.Transient;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void addOrder(Order order) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            int id = orderDao.insertOrder(conn, order);
            order.setId(id);
            for(OrderItem item : order.getOrderItemMap().values()) {
                orderDao.insertOrderItem(conn, item);
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            if(conn!=null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Order> selectAll(int userid) {
        List<Order> list = null;
        try {
            list = orderDao.selectAll(userid);
            for(Order order : list) {
                List<OrderItem> list1 = orderDao.selectAllItem(order.getId());
                order.setItem(list1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Page getOrderPage(int status, int pageNumber) {
        Page p = new Page();
        List list = null;
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        try {
            totalCount = orderDao.getOrderCount(status);
            p.setPageSizeAndTotalCount(10, totalCount);
            list = orderDao.selectOrderList(status, pageNumber, 10);
            for(Order o : (List<Order>)list) {
                List<OrderItem> l = orderDao.selectAllItem(o.getId());
                o.setItem(l);
            }
            p.setList(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
}
