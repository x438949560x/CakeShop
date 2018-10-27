package com.ccsu.service.impl;

import com.ccsu.dao.GoodsDao;
import com.ccsu.dao.impl.GoodsDaoImpl;
import com.ccsu.service.GoodsService;

import java.util.List;
import java.util.Map;

public class GoodsServiceImpl implements GoodsService {

    private GoodsDao goodsDao = new GoodsDaoImpl();
    @Override
    public List<Map<String, Object>> getGoodsList(int id) {
         List<Map<String, Object>> list = null;
         try{
             return goodsDao.getGoodsList(id);
         } catch (Exception e){
             e.printStackTrace();
         }
        return list;
    }

    @Override
    public Map<String, Object> getScrollGoods() {
        Map<String, Object> scroll = null;
        try{
            return goodsDao.getScrollGoods();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scroll;
    }
}
