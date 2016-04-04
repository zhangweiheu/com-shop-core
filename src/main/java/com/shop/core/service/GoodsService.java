package com.shop.core.service;


import com.shop.core.model.Goods;

import java.util.List;

/**
 * Created by zhangwei on 16/1/25.
 */

public interface GoodsService {
    Goods findGoodsById(int gid);

    int getTotalCount();

    boolean deleteGoodsById(int Gid);

    int saveGoods(Goods goods);

    int updateGoods(Goods goods);

    List<Goods> listAllGoods(int offset, int pageSize);

    List<Goods> listAllGoodsByAttr(int offset, int pageSize, Goods goods);
}
