package com.ccsu.dao;

import com.ccsu.domain.Type;

import java.sql.SQLException;
import java.util.List;

public interface TypeDao {
    public List<Type> selectAll() throws SQLException;

    public Type select(int id) throws SQLException;
}
