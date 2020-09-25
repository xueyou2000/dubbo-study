package com.xueyou.studyproject.dubbo.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 接口响应
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/25 1:48 下午
 */
@Data
@ApiModel(value = "Response", description = "接口响应")
public class Response<T> {

    /**
     * 正常响应 状态码
     */
    public static final String OK = "200";

    /**
     * 正常响应 状态编号
     */
    public static final String OK_CODE = "SUCCESS";

    /**
     * 状态码
     * 成功则响应 200
     */
    @ApiModelProperty(value = "状态码")
    private String status;

    /**
     * 状态编号
     * 成功则响应 SUCCESS
     */
    @ApiModelProperty(value = "状态编号")
    private String code;

    /**
     * 返回消息
     */
    @ApiModelProperty(value = "返回消息")
    private String message;

    /**
     * 响应数据
     */
    @ApiModelProperty(value = "响应数据")
    private T res;

    /**
     * 重定向地址
     */
    @ApiModelProperty(value = "重定向地址")
    private String redirect;

    /**
     * 判断是否响应成功
     * @return true=响应成功
     */
    public boolean ok() {
        return OK.equals(status) && OK_CODE.equals(code);
    }

    /**
     * 判断是否响应失败
     * @return true=响应失败
     */
    public boolean fail() {
        return !ok();
    }

    /**
     * 响应成功数据
     * @param data 响应数据
     * @return 成功响应
     */
    @SuppressWarnings("unchecked")
    public static <T> Response<T> Ok(T data) {
        Response res = new Response<T>();
        res.status = OK;
        res.code = OK_CODE;
        res.res = data;
        return res;
    }

    /**
     * 响应成功
     */
    public static Response Ok() {
        Response res = new Response();
        res.status = OK;
        res.code = OK_CODE;
        return res;
    }

}
