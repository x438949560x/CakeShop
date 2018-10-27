package com.ccsu.dao.impl;

import com.ccsu.dao.GoodsDao;
import com.ccsu.domain.Goods;
import com.ccsu.domain.Type;
import com.ccsu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

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
}
