package com.ccsu.dao.impl;

import com.ccsu.dao.OrderDao;
import com.ccsu.domain.Order;
import com.ccsu.domain.OrderItem;
import com.ccsu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private DataSource ds = JDBCUtils.getDataSource();
    private QueryRunner r = new QueryRunner();
    // 增加订单
    @Override
    public int insertOrder(Connection conn, Order order) throws SQLException {
        String sql = "insert into `order`(total, amount, status, paytype, name, phone, address, datetime, user_id) values(?,?,?,?,?,?,?,?,?)";
        String sql2 = "select last_insert_id()";
        r.update(conn,
                sql,
                order.getTotal(), order.getAmount(), order.getStatus(),
                order.getPaytype(), order.getName(), order.getPhone(),
                order.getAddress(), order.getDatetime(), order.getUser().getId());
        BigInteger bi =  r.query(conn, sql2, new ScalarHandler<>());
        return Integer.parseInt(bi.toString());
    }
    // 增加订单项
    @Override
    public void insertOrderItem(Connection conn, OrderItem item) throws  SQLException {
        String sql = "insert into orderitem(price,amount,goods_id,order_id) values(?,?,?,?)";
        r.update(conn,sql,item.getPrice(),item.getAmount(),item.getGoods().getId(),item.getOrder().getId());
    }

    @Override
    public List<Order> selectAll(int userid) throws SQLException {
        QueryRunner r1 = new QueryRunner(ds);
        String sql = "select * from `order` where user_id=? order by datetime desc"; // 时间倒序排,大的放上面
        return r1.query(sql, new BeanListHandler<Order>(Order.class),userid);
    }

    @Override
    public List<OrderItem> selectAllItem(int orderid) throws SQLException {
        QueryRunner r1 = new QueryRunner(ds);
        String sql = "select i.id,i.price,i.amount,g.name from orderitem i,goods g where order_id=? and i.goods_id=g.id";
        return r1.query(sql, new BeanListHandler<OrderItem>(OrderItem.class),orderid);
    }
}
