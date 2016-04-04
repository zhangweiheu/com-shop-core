package com.shop.core.mybatis;


import com.shop.core.mybatis.enums.IEnumDesc;
import com.shop.core.mybatis.enums.IEnumValue;
import com.shop.core.mybatis.enums.ParseNameReplaceValue;

@ParseNameReplaceValue
public enum ExpressStatusEnum implements IEnumDesc, IEnumValue {
    BEGIN_PROCESSED("处理中", 0),
    DELIVERED("已发货", 1),
    IN_TRANSIT("送货中", 2),
    RECEIVE("待签收", 3),
    RECEIVED("已签收", 4);

    private String desc;
    private int value;


    ExpressStatusEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    public static ExpressStatusEnum parse(int val) {
        for (ExpressStatusEnum cycle : ExpressStatusEnum.values()) {
            if (cycle.value == val) {
                return cycle;
            }
        }
        return null;
    }

    @Override
    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
