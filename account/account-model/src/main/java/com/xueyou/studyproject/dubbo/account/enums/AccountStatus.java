package com.xueyou.studyproject.dubbo.account.enums;

import com.xueyou.studyproject.dubbo.common.enums.BaseEnum;

/**
 * 账户状态
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/25 1:12 下午
 */
public enum AccountStatus implements BaseEnum {

    NORMAL("正常"),
    END_IN("止入"),
    END_OUT("止出"),
    FREEZE("冻结"),
    CLOSE("注销");

    AccountStatus(String desc) {
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
