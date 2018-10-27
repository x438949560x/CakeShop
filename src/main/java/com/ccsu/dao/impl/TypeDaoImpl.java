package com.ccsu.dao.impl;

import com.ccsu.dao.TypeDao;
import com.ccsu.domain.Type;
import com.ccsu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class TypeDaoImpl implements TypeDao {
    private DataSource ds = JDBCUtils.getDataSource();

    @Override
    public List<Type> selectAll() {
        QueryRunner r = new QueryRunner(ds);
        String sql = "select * from type";
        try {
            return r.query(sql, new BeanListHandler<Type>(Type.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
