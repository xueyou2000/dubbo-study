package com.xueyou.studyproject.dubbo.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xueyou.studyproject.dubbo.account.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * 账户信息数据访问层
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/27 4:16 下午
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}
