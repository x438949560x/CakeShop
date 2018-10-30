package com.ccsu.domain;

import java.util.*;

import java.math.BigDecimal;

public class Order {
    private int id;
    private BigDecimal total;
    private int amount;  // 商品总数
    private int status; // 1未付款2已付款3已发货4已完成
    private int paytype; //1微信2支付宝3货到付款
    private String name;
    private String phone;
    private String address;
    private Date datetime;
    private User user;
    private Map<Integer, OrderItem> orderItemMap = new HashMap<>();
    private List<OrderItem> item = new ArrayList<>();

    public List<OrderItem> getItem() {
        return item;
    }

    public void setItem(List<OrderItem> item) {
        this.item = item;
    }

    public Map<Integer, OrderItem> getOrderItemMap() {
        return orderItemMap;
    }

    public void setOrderItemMap(Map<Integer, OrderItem> orderItemMap) {
        this.orderItemMap = orderItemMap;
    }

    // 购物车商品删除
    public void delete(int goodsid) {
        orderItemMap.remove(goodsid);
    }

    // 购物车商品减少
    public void lesson(int goodsid) {
        if(orderItemMap.containsKey(goodsid)) {
            OrderItem item = orderItemMap.get(goodsid);
            item.setAmount(item.getAmount()-1);
            amount--;
            total = total.subtract(item.getPrice());
            if(item.getAmount() <= 0) {
                orderItemMap.remove(goodsid);
            }
        }
    }

    // 购物车的商品添加
    public void  addGoods(Goods goods) {
        if(orderItemMap.containsKey(goods.getId())) {
            OrderItem item = orderItemMap.get(goods.getId());
            item.setAmount(item.getAmount() + 1);
        } else {
            OrderItem item = new OrderItem(goods.getPrice(),1,goods,this);
            orderItemMap.put(goods.getId(), item);
        }
        amount++;
        total = total.add(goods.getPrice());
    }

    public Order() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPaytype() {
        return paytype;
    }

    public void setPaytype(int paytype) {
        this.paytype = paytype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
