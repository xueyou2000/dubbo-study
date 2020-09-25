package com.xueyou.studyproject.dubbo.account.dubbo.impl;

import com.xueyou.studyproject.dubbo.account.dubbo.AccountService;
import com.xueyou.studyproject.dubbo.account.entity.Account;
import com.xueyou.studyproject.dubbo.account.enums.AccountStatus;
import com.xueyou.studyproject.dubbo.common.enums.UserType;
import org.apache.dubbo.config.annotation.DubboService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 账户远程接口实现
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/25 2:49 下午
 */
@DubboService
public class AccountServiceImpl implements AccountService {

    /**
     * 查询全部账户
     */
    @Override
    public List<Account> queryAllAccount() {
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
        return accounts;
    }
}