package com.xueyou.studyproject.dubbo.account.controller;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xueyou.studyproject.dubbo.account.dto.AccountQueryDto;
import com.xueyou.studyproject.dubbo.account.entity.Account;
import com.xueyou.studyproject.dubbo.account.mapper.AccountMapper;
import com.xueyou.studyproject.dubbo.account.service.AccountService;
import com.xueyou.studyproject.dubbo.common.vo.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 账户控制器
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/25 1:47 下午
 */
@Slf4j
@RestController
@RequestMapping("/account")
@Api(value = "AccountController", tags = "账户实体控制器")
@NacosPropertySource(dataId = "account-config")
public class AccountController {

    @Value(value = "${accountStatus:}")
    private String accountStatus;

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private AccountService accountService;

    /**
     * 新增账户实体
     */
    @ApiOperation(value = "新增账户实体",  httpMethod = "POST")
    @RequestMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Boolean> add(@RequestBody Account account) {
        return Response.Ok(accountService.save(account));
    }

    /**
     * 修改账户实体
     */
    @ApiOperation(value = "修改账户实体",  httpMethod = "POST")
    @RequestMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Boolean> update(@RequestBody Account account) {
        account.setUpdateTime(LocalDateTime.now());
        return Response.Ok(accountService.updateById(account));
    }

    /**
     * 分页查询账户信息
     */
    @ApiOperation(value = "分页查询账户信息",  httpMethod = "POST")
    @PostMapping(value = "/findByPage/{pageNumber}/{pageSize}", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "path",required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", paramType = "path",required = true)
    })
    public Response<IPage<Account>> findByPage(@PathVariable Integer pageNumber, @PathVariable Integer pageSize, @RequestBody AccountQueryDto accountQueryDto) {
        IPage<Account> page = new Page<>(pageNumber, pageSize);
        return Response.Ok(accountService.queryByPage(page,accountQueryDto.getAccount(), accountQueryDto.getQueryBaseDto()));
    }

    /**
     * 查询全部账户
     */
    @ApiOperation(value = "查询全部账户",  httpMethod = "POST")
    @RequestMapping(value = "/queryAllAccount", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Account>> queryAllAccount() {
        log.info("accountStatus=[{}]", accountStatus);
        return Response.Ok(accountMapper.selectList(null));

    }

}
