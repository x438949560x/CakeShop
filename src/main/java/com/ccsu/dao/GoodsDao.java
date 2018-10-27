package com.ccsu.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface GoodsDao {
    public List<Map<String,Object>> getGoodsList(int id) throws SQLException;

    public Map<String, Object> getScrollGoods() throws SQLException;
}
