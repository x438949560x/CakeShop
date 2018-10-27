package com.ccsu.service.impl;

import com.ccsu.dao.TypeDao;
import com.ccsu.dao.impl.TypeDaoImpl;
import com.ccsu.domain.Type;
import com.ccsu.service.TypeService;

import java.util.List;

public class TypeServiceImpl implements TypeService {
    private TypeDao typeDao = new TypeDaoImpl();

    @Override
    public List<Type> selectAll() {
        return typeDao.selectAll();
    }
}
