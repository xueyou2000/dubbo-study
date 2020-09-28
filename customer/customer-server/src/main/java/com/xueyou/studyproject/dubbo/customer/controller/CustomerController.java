package com.xueyou.studyproject.dubbo.customer.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xueyou.studyproject.dubbo.account.dubbo.AccountDubbo;
import com.xueyou.studyproject.dubbo.account.entity.Account;
import com.xueyou.studyproject.dubbo.common.vo.Response;
import com.xueyou.studyproject.dubbo.customer.dto.CustomerQueryDto;
import com.xueyou.studyproject.dubbo.customer.entity.Customer;
import com.xueyou.studyproject.dubbo.customer.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

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

    @Resource
    private CustomerService customerService;

    @DubboReference(version = "${dubbo.service.version}", check = false)
    private AccountDubbo accountDubbo;

    /**
     * Dubbo远程调用测试
     */
    @ApiOperation(value = "Dubbo远程调用测试",  httpMethod = "POST")
    @RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<List<Account>> hello() {
        return  Response.Ok(accountDubbo.queryAllAccount());
    }

    /**
     * 新增商户实体
     */
    @ApiOperation(value = "新增商户实体",  httpMethod = "POST")
    @RequestMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Boolean> add(@RequestBody Customer customer) {
        return Response.Ok(customerService.save(customer));
    }

    /**
     * 修改商户实体
     */
    @ApiOperation(value = "修改商户实体",  httpMethod = "POST")
    @RequestMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Boolean> update(@RequestBody Customer customer) {
        customer.setUpdateTime(LocalDateTime.now());
        return Response.Ok(customerService.updateById(customer));
    }

    /**
     * 分页查询商户信息
     */
    @ApiOperation(value = "分页查询商户信息",  httpMethod = "POST")
    @PostMapping(value = "/findByPage/{pageNumber}/{pageSize}", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "path",required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", paramType = "path",required = true)
    })
    public Response<IPage<Customer>> findByPage(@PathVariable Integer pageNumber, @PathVariable Integer pageSize, @RequestBody CustomerQueryDto queryDto) {
        IPage<Customer> page = new Page<>(pageNumber, pageSize);
        return Response.Ok(customerService.queryByPage(page, queryDto.getCustomer(), queryDto.getQueryBaseDto()));
    }

    /**
     * 查询全部商户
     */
    @ApiOperation(value = "查询全部商户",  httpMethod = "POST")
    @RequestMapping(value = "/queryAllCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Customer>> queryAllCustomer() {
        return Response.Ok(customerService.getBaseMapper().selectList(null));
    }

}
