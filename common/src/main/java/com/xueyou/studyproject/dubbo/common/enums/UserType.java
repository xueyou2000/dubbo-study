package com.xueyou.studyproject.dubbo.common.enums;

/**
 * 用户类型
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/25 1:15 下午
 */
public enum UserType implements BaseEnum {

    AGENT("代理商"),
    CUSTOMER("商户");

    UserType(String desc) {
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
