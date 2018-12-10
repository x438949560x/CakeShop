package com.ccsu.service;

import com.ccsu.domain.Order;
import com.ccsu.domain.Page;

import java.util.List;

public interface OrderService {
    public void addOrder(Order order);

    public List<Order> selectAll(int userid);

    Page getOrderPage(int status, int pageNumber);
}
