package com.shop.core.service.impl;

import com.shop.core.dao.PassDao;
import com.shop.core.mybatis.enums.PassStatusEnum;
import com.shop.core.model.Pass;
import com.shop.core.service.PassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhang on 2016/3/24.
 */
@Service
public class PassServiceImpl implements PassService {

    @Autowired
    PassDao passDao;

    @Override
    public int getTotalCount() {
        Pass pass = new Pass();
        return passDao.countPassByAttr(pass);
    }

    @Override
    public boolean deletePassById(int Oid) {
        Pass pass = new Pass();
        pass.setStatus(PassStatusEnum.USED);
        return passDao.updatePass(pass) > 0;
    }

    @Override
    public int savePass(Pass pass) {
        return passDao.savePass(pass);
    }

    @Override
    public int updatePass(Pass pass) {
        return passDao.updatePass(pass);
    }

    @Override
    public List<Pass> listAllPass(int offset, int pageSize) {
        return passDao.listAllPassByAttr(offset, pageSize, null);
    }
}
