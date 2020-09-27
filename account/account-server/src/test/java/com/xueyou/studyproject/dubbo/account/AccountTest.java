package com.xueyou.studyproject.dubbo.account;

import com.xueyou.studyproject.dubbo.account.entity.Account;
import com.xueyou.studyproject.dubbo.account.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 账户测试
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/27 4:36 下午
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTest {

    @Resource
    private AccountMapper accountMapper;

    @Test
    public void test() {
        List<Account> accounts = accountMapper.selectList(null);
        Assert.assertEquals(1,accounts.size());
        log.info("账户列表: [{}]", accounts);
    }


}
