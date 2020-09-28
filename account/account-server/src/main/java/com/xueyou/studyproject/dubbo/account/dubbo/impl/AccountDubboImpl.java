package com.xueyou.studyproject.dubbo.account.dubbo.impl;

import com.xueyou.studyproject.dubbo.account.dubbo.AccountDubbo;
import com.xueyou.studyproject.dubbo.account.entity.Account;
import com.xueyou.studyproject.dubbo.account.service.AccountService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 账户远程接口实现
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/25 2:49 下午
 */
@DubboService(version = "${dubbo.service.version}")
public class AccountDubboImpl implements AccountDubbo {

    @Resource
    private AccountService accountService;

    /**
     * 查询全部账户
     */
    @Override
    public List<Account> queryAllAccount() {
        return accountService.list();
    }
}
