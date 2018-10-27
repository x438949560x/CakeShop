package com.ccsu.dao;

import com.ccsu.domain.Goods;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface GoodsDao {
    public List<Map<String,Object>> getGoodsList(int id) throws SQLException;

    public Map<String, Object> getScrollGoods() throws SQLException;

    public List<Goods> selectGoods(int typeId, int pageNumber, int pageSize) throws SQLException;

    public int getGoodsCount(int typeId) throws SQLException;

    public List<Goods> selectGoodsRecommend(int type, int pageNumber, int pageSize) throws SQLException;

    public int selectGoodsRecommendCount(int type) throws SQLException;
}
