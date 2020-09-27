package com.xueyou.studyproject.dubbo.customer.controller;

import com.xueyou.studyproject.dubbo.account.dubbo.AccountService;
import com.xueyou.studyproject.dubbo.common.vo.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
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
@Slf4j
@RestController
@RequestMapping("/customer")
@Api(value = "CustomerController", tags = "商户实体控制器")
public class CustomerController {

    @DubboReference(version = "${dubbo.service.version}", check = false)
    private AccountService accountService;

    /**
     * 测试
     */
    @ApiOperation(value = "测试",  httpMethod = "POST")
    @RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<String> hello() {
        log.info("Dubbo 远程调用, [{}]", accountService.queryAllAccount());
        return  Response.Ok("Hello Dubbo");
    }


}
