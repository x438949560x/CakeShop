package com.ccsu.service.impl;

import com.ccsu.dao.TypeDao;
import com.ccsu.dao.impl.TypeDaoImpl;
import com.ccsu.domain.Type;
import com.ccsu.service.TypeService;

import java.sql.SQLException;
import java.util.List;

public class TypeServiceImpl implements TypeService {
    private TypeDao typeDao = new TypeDaoImpl();

    @Override
    public List<Type> selectAll() {
        List<Type> list = null;
        try{
            list =  typeDao.selectAll();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Type select(int id) {
        Type t = null;
        try{
            t = typeDao.select(id);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return t;
    }
}
