package com.ccsu.dao.impl;

import com.ccsu.dao.TypeDao;
import com.ccsu.domain.Type;
import com.ccsu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class TypeDaoImpl implements TypeDao {
    private DataSource ds = JDBCUtils.getDataSource();
    private QueryRunner r = new QueryRunner(ds);
    // 查询有哪些系列
    @Override
    public List<Type> selectAll() throws SQLException {
        String sql = "select * from type";
        return r.query(sql, new BeanListHandler<Type>(Type.class));

    }

    @Override
    public Type select(int id) throws SQLException {
        String sql = "select * from type where id = ?";
        return r.query(sql, new BeanHandler<Type>(Type.class), id);
    }
}
