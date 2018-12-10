package com.ccsu.domain;

import java.math.BigDecimal;

public class Goods {
    private int id;
    private String name;
    private String cover;
    private String image1;
    private String image2;
    private BigDecimal price;
    private String intro;
    private int stock;
    private Type type_id;

    public Goods(){}

    public Goods(int id,String name,String cover,String image1,String image2,BigDecimal price,
                 String intro,int stock,Type type_id) {
        this.id = id;
        this.name = name;
        this.cover = cover;
        this.image1 = image1;
        this.image2 = image2;
        this.price = price;
        this.intro = intro;
        this.stock = stock;
        this.type_id = type_id;
    }

    public void setTypeid(int typeid) {
        if(type_id==null){
            type_id = new Type();
        }
        type_id.setId(typeid);
    }

    public void setTypename(String typename) {
        if(type_id==null){
            type_id = new Type();
        }
        type_id.setName(typename);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Type getType_id() {
        return type_id;
    }  // 返回type对象

    public void setType_id(Type type_id) {
        this.type_id = type_id;
    }  // 接收type对象
}
