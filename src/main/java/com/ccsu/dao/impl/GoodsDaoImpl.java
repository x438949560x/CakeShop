package com.ccsu.dao.impl;

import com.ccsu.dao.GoodsDao;
import com.ccsu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class GoodsDaoImpl implements GoodsDao {

    private DataSource ds = JDBCUtils.getDataSource();

    @Override
    public List<Map<String, Object>> getGoodsList(int id) throws SQLException {
        QueryRunner r = new QueryRunner(ds);
        String sql = "select g.id,g.name,g.cover,g.price,r.type,t.name typeName from goods g,type t,recommend r where g.id=r.goods_id and g.type_id=t.id and r.type=?";
        return r.query(sql, new MapListHandler(), id);
    }

    @Override
    public Map<String, Object> getScrollGoods() throws SQLException {
        QueryRunner r = new QueryRunner(ds);
        String sql = "select g.id,g.name,g.cover,g.price from goods g,recommend r where g.id=r.goods_id and r.type=1";
        return r.query(sql, new MapHandler());
    }

}
