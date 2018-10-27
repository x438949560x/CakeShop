package com.ccsu.service;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    public List<Map<String,Object>> getGoodsList(int id);

    public Map<String, Object> getScrollGoods();
}
