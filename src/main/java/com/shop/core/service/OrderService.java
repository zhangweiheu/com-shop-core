package com.shop.core.service;


import com.shop.core.model.OrderForm;

import java.util.List;

/**
 * Created by zhangwei on 16/1/25.
 */

public interface OrderService {
    OrderForm findOrderByOId(int oid);

    List<OrderForm> findOrderByUId(int uid);

    int getTotalCount();

    int getTotalCountByAttr(OrderForm order);

    boolean deleteOrderById(int oid);

    int saveOrder(OrderForm order);

    int updateOrder(OrderForm order);

    List<OrderForm> listAllOrder(int offset, int pageSize);

    List<OrderForm> listAllOrderByAttr(int offset, int pageSize, OrderForm order);
}
