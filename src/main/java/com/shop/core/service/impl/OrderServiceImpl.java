package com.shop.core.service.impl;

import com.shop.core.dao.OrderDao;
import com.shop.core.model.OrderForm;
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
    public OrderForm findOrderByOId(int oid) {
        return orderDao.findOrderById(oid);
    }

    @Override
    public List<OrderForm> findOrderByUId(int uid) {
        return orderDao.findOrderByUid(uid);
    }

    @Override
    public int getTotalCount() {
        OrderForm order = new OrderForm();
        return orderDao.countAllOrderByAttr(order);
    }

    @Override
    public int getTotalCountByAttr(OrderForm order) {
        return orderDao.countAllOrderByAttr(order);
    }

    @Override
    public boolean deleteOrderById(int Oid) {
        return orderDao.deleteOrdersById(Oid) > 0;
    }

    @Override
    public int saveOrder(OrderForm order) {
        return orderDao.saveOrder(order);
    }

    @Override
    public int updateOrder(OrderForm order) {
        return orderDao.updateOrder(order);
    }

    @Override
    public List<OrderForm> listAllOrder(int offset, int pageSize) {
        return orderDao.listAllOrder(offset, pageSize);
    }

    @Override
    public List<OrderForm> listAllOrderByAttr(int offset, int pageSize, OrderForm order) {
        return orderDao.listOrdersByAttr(offset, pageSize, order);
    }
}
