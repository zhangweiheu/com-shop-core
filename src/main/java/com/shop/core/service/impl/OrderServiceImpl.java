package com.shop.core.service.impl;

import com.shop.core.dao.OrderDao;
import com.shop.core.model.Order;
import com.shop.core.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhang on 2016/3/24.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Override
    public int getTotalCount() {
        Order order = new Order();
        return orderDao.countAllOrderByAttr(order);
    }

    @Override
    public boolean deleteOrderById(int Oid) {
        return orderDao.deleteOrdersById(Oid) > 0;
    }

    @Override
    public int saveOrder(Order order) {
        return orderDao.saveOrder(order);
    }

    @Override
    public int updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }

    @Override
    public List<Order> listAllOrder(int offset, int pageSize) {
        return orderDao.listAllOrder(offset, pageSize);
    }
}
