package com.ccsu.domain;

public class Recommend {
    private int id;
    private int type;
    private Goods goods_id;

    public Recommend() {}

    public Recommend(int id, int type, Goods goods_id) {
        this.id = id;
        this.type = type;
        this.goods_id = goods_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Goods getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Goods goods_id) {
        this.goods_id = goods_id;
    }
}
