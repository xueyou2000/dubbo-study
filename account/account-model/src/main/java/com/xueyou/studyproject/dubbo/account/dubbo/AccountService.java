package com.xueyou.studyproject.dubbo.account.dubbo;

import com.xueyou.studyproject.dubbo.account.entity.Account;

import java.util.List;

/**
 * 账户远程接口
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/25 2:48 下午
 */
public interface AccountService {

    /**
     * 查询全部账户
     */
    List<Account> queryAllAccount();

}
