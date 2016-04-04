package com.shop.core.service;


import com.shop.core.model.OrderDetail;

import java.util.List;

/**
 * Created by zhangwei on 16/1/25.
 */

public interface CartService {
    OrderDetail findOrderDetailByAttr(OrderDetail orderDetail);

    int getTotalCountByUid(int uid);

    int deleteCartByODid(int ODid);

    int saveCart(OrderDetail orderDetail);

    int updateCart(OrderDetail orderDetail);

    List<OrderDetail> listUserAllCart(int offset, int pageSize, int uid);
}
