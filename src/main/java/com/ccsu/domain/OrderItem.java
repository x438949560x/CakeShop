package com.ccsu.domain;

import java.math.BigDecimal;

public class OrderItem {
    private int id;
    private BigDecimal price;
    private int amount;
    private Goods goods;
    private Order order; // order_id
    private String goodsName;

    public String getGoodsName() {
        return goodsName;
    }

    public void setName(String name) {
        this.goodsName = name;
    }

    public OrderItem(BigDecimal price, int amount, Goods goods, Order order) {
        this.price = price;
        this.amount = amount;
        this.goods = goods;
        this.order = order;
    }

    public OrderItem() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
