package com.ccsu.service;

import com.ccsu.domain.Goods;
import com.ccsu.domain.Page;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface GoodsService {
    public List<Map<String,Object>> getGoodsList(int id);

    public Map<String, Object> getScrollGoods();

    public Page getGoodsPage(int typeId, int pageNumber, int pageSize);

    public Page getGoodsRecommendPage(int type, int pageNumber, int pageSize);

    public Goods getById(int id);

    Page getSearchGoodsPage(String keyword, int pageNo);
}
