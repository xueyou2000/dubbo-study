package com.xueyou.studyproject.dubbo.account.enums;

import com.xueyou.studyproject.dubbo.common.enums.BaseEnum;

/**
 * 账户类型
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/25 12:59 下午
 */
public enum AccountType implements BaseEnum {

    CASH("现金账户"),
    POINT("积分账户"),
    DEPOSIT("保证金账户"),
    FINANCING("理财账户"),
    CREDIT("信用账户");

    AccountType(String desc) {
        this.desc = desc;
    }

    /** 枚举描述 */
    private String desc;

    /** 获取枚举中文描述 */
    @Override
    public String getDesc() {
        return desc;
    }

}
