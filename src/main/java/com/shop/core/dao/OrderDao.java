package com.shop.core.dao;

import com.shop.core.model.OrderForm;

import java.util.List;

/**
 * Created by zhang on 2016/3/24.
 */
public interface OrderDao {
    List<OrderForm> listAllOrder(int offset, int pageSize);

    int countAllOrderByAttr(OrderForm order);

    List<OrderForm> listOrdersByAttr(int offset, int pageSize, OrderForm order);

    OrderForm findOrderById(int Oid);

    List<OrderForm> findOrderByUid(int Uid);

    int deleteOrdersById(int Oid);

    int updateOrder(OrderForm order);

    int saveOrder(OrderForm order);
}
