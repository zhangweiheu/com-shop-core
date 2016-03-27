package com.shop.core.dao;

import com.shop.core.model.Pass;

import java.util.List;

/**
 * Created by zhang on 2016/3/24.
 */
public interface PassDao {

    int countPassByAttr(Pass pass);

    Pass findPassById(int pid);

    int savePass(Pass pass);

    int updatePass(Pass pass);

    List<Pass> listAllPassByAttr(Integer offset, Integer pageSize, Pass pass);
}
