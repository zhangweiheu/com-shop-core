package com.shop.core.dao.impl;

import com.shop.core.dao.OrderDao;
import com.shop.core.mapper.OrderDetailMapper;
import com.shop.core.mapper.OrderFormMapper;
import com.shop.core.model.OrderDetailCondition;
import com.shop.core.model.OrderForm;
import com.shop.core.model.OrderFormCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by zhang on 2016/3/24.
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    OrderFormMapper orderMapper;

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Override
    public List<OrderForm> listAllOrder(int offset, int pageSize) {
        OrderFormCondition condition = new OrderFormCondition();
        condition.setLimitOffset(offset);
        condition.setLimitSize(pageSize);
        return orderMapper.selectByCondition(condition);
    }

    @Override
    public int countAllOrderByAttr(OrderForm order) {
        return orderMapper.countByCondition(convertOrder2Condition(null, null, order));
    }

    @Override
    public List<OrderForm> listOrdersByAttr(int offset, int pageSize, OrderForm order) {
        return orderMapper.selectByCondition(convertOrder2Condition(offset, pageSize, order));
    }

    @Override
    public OrderForm findOrderById(int Oid) {
        return orderMapper.selectById(Oid);
    }

    @Override
    public List<OrderForm> findOrderByUid(int Uid) {
        OrderForm order = new OrderForm();
        order.setUid(Uid);
        List<OrderForm> list = orderMapper.selectByCondition(convertOrder2Condition(null, null, order));
        return CollectionUtils.isEmpty(list) ? null : list;
    }

    @Override
    public int deleteOrdersById(int oid) {
        OrderDetailCondition condition = new OrderDetailCondition();
        condition.createCriteria().andOrderIdEqualTo(oid);
        orderDetailMapper.deleteByCondition(condition);
        return orderMapper.deleteById(oid);
    }

    @Override
    public int updateOrder(OrderForm order) {
        return orderMapper.updateByIdSelective(order);
    }

    @Override
    public int saveOrder(OrderForm order) {
        return orderMapper.insertSelective(order);
    }

    private OrderFormCondition convertOrder2Condition(Integer offset, Integer pageSize, OrderForm order) {
        OrderFormCondition condition = new OrderFormCondition();
        if (null != offset) {
            condition.setLimitOffset(offset);
        }

        if (null != pageSize) {
            condition.setLimitSize(pageSize);
        }

        if (null == order) {
            return condition;
        }

        if (null != order.getId()) {
            condition.createCriteria().andIdEqualTo(order.getId());
        }

        if (null != order.getExpressStatus()) {
            condition.createCriteria().andExpressStatusEqualTo(order.getExpressStatus());
        }

        if (null != order.getUid()) {
            condition.createCriteria().andUidEqualTo(order.getUid());
        }

        if (null != order.getOrderPrice()) {
            condition.createCriteria().andOrderPriceEqualTo(order.getOrderPrice());
        }
        return condition;
    }
}
