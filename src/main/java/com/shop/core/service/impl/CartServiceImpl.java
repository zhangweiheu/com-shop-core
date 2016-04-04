package com.shop.core.service.impl;

import com.shop.core.dao.OrderDetailDao;
import com.shop.core.mapper.OrderDetailMapper;
import com.shop.core.model.OrderDetail;
import com.shop.core.model.OrderDetailCondition;
import com.shop.core.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by zhang on 2016/3/24.
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    OrderDetailDao orderDetailDao;

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Override
    public OrderDetail findOrderDetailByAttr(OrderDetail orderDetail) {
        OrderDetailCondition condition = new OrderDetailCondition();
        condition.createCriteria().andUidEqualTo(orderDetail.getUid()).andOrderIdIsNull().andGoodsIdEqualTo(orderDetail.getGoodsId());
        List<OrderDetail> orderDetails = orderDetailMapper.selectByCondition(condition);
        return CollectionUtils.isEmpty(orderDetails) ? null : orderDetails.get(0);
    }

    @Override
    public int getTotalCountByUid(int uid) {
        OrderDetailCondition condition = new OrderDetailCondition();
        condition.createCriteria().andUidEqualTo(uid).andOrderIdIsNull();
        return orderDetailMapper.countByCondition(condition);
    }

    @Override
    public int deleteCartByODid(int odid) {
        return orderDetailDao.deleteOrderDetailById(odid);
    }

    @Override
    public int saveCart(OrderDetail orderDetail) {
        return orderDetailDao.saveOrderDetail(orderDetail);
    }

    @Override
    public int updateCart(OrderDetail orderDetail) {
        return orderDetailDao.updateOrderDetail(orderDetail);
    }

    @Override
    public List<OrderDetail> listUserAllCart(int offset, int pageSize, int uid) {
        OrderDetailCondition condition = new OrderDetailCondition();
        condition.setLimitOffset(offset);
        condition.setLimitSize(pageSize);
        condition.createCriteria().andUidEqualTo(uid).andOrderIdIsNull();
        return orderDetailMapper.selectByCondition(condition);
    }
}
