package com.xueyou.studyproject.dubbo.customer.controller;

import com.xueyou.studyproject.dubbo.common.vo.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商户实体控制器
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/25 2:29 下午
 */
@RestController
@RequestMapping("/customer")
@Api(value = "CustomerController", tags = "商户实体控制器")
public class CustomerController {

    /**
     * 测试
     */
    @ApiOperation(value = "测试",  httpMethod = "POST")
    @RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<String> hello() {
        return  Response.Ok("Hello Dubbo");
    }


}
