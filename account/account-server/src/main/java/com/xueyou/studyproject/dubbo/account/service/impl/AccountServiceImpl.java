package com.xueyou.studyproject.dubbo.account.service.impl;

import com.xueyou.studyproject.dubbo.account.entity.Account;
import com.xueyou.studyproject.dubbo.account.mapper.AccountMapper;
import com.xueyou.studyproject.dubbo.account.service.AccountService;
import com.xueyou.studyproject.dubbo.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 账户服务实现
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/28 9:40 上午
 */
@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<AccountMapper, Account> implements AccountService {

}
