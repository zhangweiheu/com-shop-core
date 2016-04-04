package com.shop.core.mapper;

import com.shop.core.model.OrderForm;
import com.shop.core.model.OrderFormCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderFormMapper {
    int countByCondition(OrderFormCondition example);

    int deleteByCondition(OrderFormCondition example);

    int deleteById(Integer id);

    int insert(OrderForm record);

    int insertSelective(OrderForm record);

    List<OrderForm> selectByCondition(OrderFormCondition example);

    OrderForm selectById(Integer id);

    int updateByConditionSelective(@Param("record") OrderForm record, @Param("example") OrderFormCondition example);

    int updateByCondition(@Param("record") OrderForm record, @Param("example") OrderFormCondition example);

    int updateByIdSelective(OrderForm record);

    int updateById(OrderForm record);
}