package com.ccsu.service.impl;

import com.ccsu.dao.GoodsDao;
import com.ccsu.dao.impl.GoodsDaoImpl;
import com.ccsu.domain.Goods;
import com.ccsu.domain.Page;
import com.ccsu.service.GoodsService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class GoodsServiceImpl implements GoodsService {

    private GoodsDao goodsDao = new GoodsDaoImpl();
    // 返回热销，新品
    @Override
    public List<Map<String, Object>> getGoodsList(int id) {
         List<Map<String, Object>> list = null;
         try{
             list =  goodsDao.getGoodsList(id);
         } catch (Exception e){
             e.printStackTrace();
         }
        return list;
    }

    // 返回横幅商品
    @Override
    public Map<String, Object> getScrollGoods() {
        Map<String, Object> scroll = null;
        try{
            scroll =  goodsDao.getScrollGoods();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scroll;
    }
    // 返回分页模型
    public Page getGoodsPage(int typeId, int pageNumber, int pageSize, int sortId) {
        Page p = new Page();
        List list = null;
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        try {
            totalCount = goodsDao.getGoodsCount(typeId);
            p.setPageSizeAndTotalCount(pageSize, totalCount);
            if(sortId == 1){ // 正序
                list = goodsDao.selectGoodsByPriceAsc(typeId, pageNumber, pageSize);
            }
            else if(sortId == 2){ // 反序
                list = goodsDao.selectGoodsByPriceDesc(typeId, pageNumber, pageSize);
            }else{
                list = goodsDao.selectGoods(typeId, pageNumber, pageSize);
            }
            p.setList(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public Page getGoodsRecommendPage(int type, int pageNumber, int pageSize) {
        Page p = new Page();
        List list = null;
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        try {
            totalCount = goodsDao.selectGoodsRecommendCount(type);
            p.setPageSizeAndTotalCount(pageSize, totalCount);
            list = goodsDao.selectGoodsRecommend(type, pageNumber, pageSize);
            p.setList(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public Goods getById(int id) {
        Goods g = null;
        try{
            g = goodsDao.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return g;
    }

    @Override
    public Page getSearchGoodsPage(String keyword, int pageNumber) {
        Page p = new Page();
        List list = null;
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        try {
            totalCount = goodsDao.getSearchCount(keyword);
            p.setPageSizeAndTotalCount(8, totalCount);
            list = goodsDao.selectSearchGoods(keyword, pageNumber, 8);
            p.setList(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
}
