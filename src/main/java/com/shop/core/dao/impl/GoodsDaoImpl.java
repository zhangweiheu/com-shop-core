package com.shop.core.dao.impl;

import com.shop.core.dao.GoodsDao;
import com.shop.core.mybatis.GoodsStatusEnum;
import com.shop.core.mapper.GoodsMapper;
import com.shop.core.model.Goods;
import com.shop.core.model.GoodsCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhang on 2016/3/24.
 */
@Repository
public class GoodsDaoImpl implements GoodsDao {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> listAllGoods(int offset, int pageSize) {
        Goods goods = new Goods();
        goods.setStatus(GoodsStatusEnum.NORMAL);
        return goodsMapper.selectByCondition(convertGoodsAttr2Condition(offset, pageSize, goods));
    }

    @Override
    public int countAllGoodsByAttr(Goods goods) {
        return goodsMapper.countByCondition(convertGoodsAttr2Condition(null, null, goods));
    }

    @Override
    public List<Goods> listGoodsByAttr(int offset, int pageSize, Goods goods) {
        return goodsMapper.selectByCondition(convertGoodsAttr2Condition(offset, pageSize, goods));
    }

    @Override
    public Goods findGoodsById(int Gid) {
        return goodsMapper.selectById(Gid);
    }

    @Override
    public int deleteGoodsById(int Gid) {
        Goods goods = new Goods();
        goods.setId(Gid);
        goods.setStatus(GoodsStatusEnum.REMOVE_SUPPORT);
        return goodsMapper.updateByIdSelective(goods);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateByIdSelective(goods);
    }

    @Override
    public int saveGoods(Goods goods) {
        return goodsMapper.insertSelective(goods);
    }

    private GoodsCondition convertGoodsAttr2Condition(Integer offset, Integer pageSize, Goods goods) {
        GoodsCondition condition = new GoodsCondition();

        if (null != offset) {
            condition.setLimitOffset(offset);
        }

        if (null != pageSize) {
            condition.setLimitSize(pageSize);
        }

        if (null == goods) {
            return condition;
        }

        GoodsCondition.Criteria criteria = condition.createCriteria();

        if (null != goods.getId()) {
            criteria.andIdEqualTo(goods.getId());
        }

        if (null != goods.getName()) {
            criteria.andNameEqualTo(goods.getName());
        }

        if (null != goods.getPrice()) {
            criteria.andPriceEqualTo(goods.getPrice());
        }

        if (null != goods.getProviderId()) {
            criteria.andProviderIdEqualTo(goods.getProviderId());
        }

        if (null != goods.getProviderPhone()) {
            criteria.andProviderPhoneEqualTo(goods.getProviderPhone());
        }

        if (null != goods.getProviderName()) {
            criteria.andProviderNameEqualTo(goods.getProviderName());
        }

        if (null != goods.getRemain()) {
            criteria.andRemainEqualTo(goods.getRemain());
        }

        if (null != goods.getStatus()) {
            criteria.andStatusEqualTo(goods.getStatus());
        }

        if (null != goods.getSellCount()) {
            criteria.andSellCountEqualTo(goods.getSellCount());
        }

        if (null != goods.getLinkPhoto()) {
            criteria.andLinkPhotoEqualTo(goods.getLinkPhoto());
        }
        condition.or(criteria);
        return condition;
    }
}
