package com.xueyou.studyproject.dubbo.account.controller;

import com.xueyou.studyproject.dubbo.account.entity.Account;
import com.xueyou.studyproject.dubbo.account.enums.AccountStatus;
import com.xueyou.studyproject.dubbo.common.enums.UserType;
import com.xueyou.studyproject.dubbo.common.vo.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 账户控制器
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/25 1:47 下午
 */
@RestController
@RequestMapping("/account")
@Api(value = "AccountController", tags = "账户实体控制器")
public class AccountController {

    /**
     * 查询全部账户
     */
    @ApiOperation(value = "查询全部账户",  httpMethod = "POST")
    @RequestMapping(value = "/queryAllAccount", produces = MediaType.APPLICATION_JSON_VALUE)
    Response<List<Account>> queryAllAccount() {
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setAccountStatus(AccountStatus.NORMAL);
        account.setAccountStatus(AccountStatus.NORMAL);
        account.setBalance(10);
        account.setTransitBal(0);
        account.setFreezeBal(0);
        account.setCreateTime(LocalDateTime.now());
        account.setUpdateTime(LocalDateTime.now());
        account.setId(1515151544);
        account.setUserId(15);
        account.setUserType(UserType.CUSTOMER);
        account.setVersion(0);
        accounts.add(account);
        return Response.Ok(accounts);

    }

}
