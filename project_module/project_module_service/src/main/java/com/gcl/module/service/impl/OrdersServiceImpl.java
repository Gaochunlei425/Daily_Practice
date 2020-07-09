package com.gcl.module.service.impl;

import com.gcl.module.dao.IOrdersDao;
import com.gcl.module.domain.Orders;
import com.gcl.module.service.IOrdersService;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    public List<Orders> findAll(int page, int size) throws Exception{

        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    public Orders findById(String ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }


}
