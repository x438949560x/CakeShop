package com.ccsu.dao.impl;

import com.ccsu.dao.GoodsDao;
import com.ccsu.domain.Goods;
import com.ccsu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class GoodsDaoImpl implements GoodsDao {

    private DataSource ds = JDBCUtils.getDataSource();
    private QueryRunner r = new QueryRunner(ds);
    // 查询热销和新品
    @Override
    public List<Map<String, Object>> getGoodsList(int id) throws SQLException {
        String sql = "select g.id,g.name,g.cover,g.price,r.type,t.name typeName from goods g,type t,recommend r where g.id=r.goods_id and g.type_id=t.id and r.type=?";
        return r.query(sql, new MapListHandler(), id);
    }

    // 查询横幅
    @Override
    public Map<String, Object> getScrollGoods() throws SQLException {
        String sql = "select g.id,g.name,g.cover,g.price from goods g,recommend r where g.id=r.goods_id and r.type=1";
        return r.query(sql, new MapHandler());
    }
    // 分页查询
    @Override
    public List<Goods> selectGoods(int typeId, int pageNumber, int pageSize) throws SQLException {
        if(typeId==0){
            String sql = "select g.id,g.name,g.cover,g.price from goods g limit ?,?";
            return r.query(sql, new BeanListHandler<Goods>(Goods.class), (pageNumber-1)*pageSize,pageSize);
        }else{
            String sql = "select g.id,g.name,g.cover,g.price from goods g where g.type_id = ? limit ?,?";
            return r.query(sql, new BeanListHandler<Goods>(Goods.class), typeId,(pageNumber-1)*pageSize,pageSize);
        }
    }

    @Override
    public List<Goods> selectGoodsByPriceDesc(int typeId, int pageNumber, int pageSize) throws SQLException {
        if(typeId==0){
            String sql = "select g.id,g.name,g.cover,g.price from goods g order by g.price desc limit ?,?";
            return r.query(sql, new BeanListHandler<Goods>(Goods.class), (pageNumber-1)*pageSize,pageSize);
        }else{
            String sql = "select g.id,g.name,g.cover,g.price from goods g where g.type_id = ? order by g.price desc limit ?,?";
            return r.query(sql, new BeanListHandler<Goods>(Goods.class), typeId,(pageNumber-1)*pageSize,pageSize);
        }
    }

    @Override
    public List<Goods> selectGoodsByPriceAsc(int typeId, int pageNumber, int pageSize) throws SQLException {
        if(typeId==0){
            String sql = "select g.id,g.name,g.cover,g.price from goods g order by g.price asc limit ?,?";
            return r.query(sql, new BeanListHandler<Goods>(Goods.class), (pageNumber-1)*pageSize,pageSize);
        }else{
            String sql = "select g.id,g.name,g.cover,g.price from goods g where g.type_id = ? order by g.price asc limit ?,?";
            return r.query(sql, new BeanListHandler<Goods>(Goods.class), typeId,(pageNumber-1)*pageSize,pageSize);
        }
    }

    @Override
    public int getGoodsCount(int typeId) throws SQLException {
        String sql = "";
        if(typeId==0){
            sql = "select count(*) from goods";
            return r.query(sql, new ScalarHandler<Long>()).intValue();
        }else{
            sql = "select count(*) from goods where type_id=?";
            return r.query(sql, new ScalarHandler<Long>(),typeId).intValue();
        }
    }

    @Override
    public List<Goods> selectGoodsRecommend(int type, int pageNumber, int pageSize) throws SQLException {
        String sql = "select g.id,g.name,g.cover,g.image1,g.image2,g.intro,g.price,g.stock from goods g,recommend r where g.id=r.goods_id and r.type=? limit ?,?";
        return r.query(sql, new BeanListHandler<Goods>(Goods.class),type,(pageNumber-1)*pageSize,pageSize);
    }

    @Override
    public int selectGoodsRecommendCount(int type) throws SQLException {
        String sql = "select count(*) from recommend where type=?";
        return r.query(sql, new ScalarHandler<Long>(),type).intValue();
    }

    @Override
    public Goods getById(int id) throws SQLException {
        String sql = "select g.id,g.name,g.cover,g.image1,g.image2,g.price,g.intro,g.stock,t.id typeid,t.name typename from goods g,type t where g.id = ? and g.type_id=t.id";
        return r.query(sql, new BeanHandler<Goods>(Goods.class), id);
    }

    @Override
    public int getSearchCount(String keyword) throws SQLException {
        String sql = "select count(*) from goods where name like ?";
        return r.query(sql, new ScalarHandler<Long>(), "%"+keyword+"%").intValue();
    }

    @Override
    public List<Goods> selectSearchGoods(String keyword, int pageNumber, int pageSize) throws SQLException {
        String sql = "select id,name,cover,price from goods where name like ? limit ?,?";
        return r.query(sql, new BeanListHandler<Goods>(Goods.class),"%"+keyword+"%",(pageNumber-1)*pageSize,pageSize);
    }
}
