package com.ccsu.test;


import com.ccsu.domain.Type;
import com.ccsu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TestQueryRunner {
    private DataSource ds = JDBCUtils.getDataSource();
    @Test
    public void testQueryRunner() throws Exception {
        QueryRunner r = new QueryRunner(ds);
        String sql = "select * from goods where id = ?";
        Map<String, Object> map = r.query(sql, new MapHandler(),3);
        for(String key : map.keySet()){
            System.out.println(key + ":" + map.get(key));
        }
    }

    @Test
    public void testTypeService(){
        QueryRunner r = new QueryRunner(ds);
        String sql = "select * from type";
        try {
            List<Type> list = r.query(sql, new BeanListHandler<Type>(Type.class));
            for(Type t : list) {
                System.out.println(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
