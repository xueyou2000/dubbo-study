package com.xueyou.studyproject.dubbo.customer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xueyou.studyproject.dubbo.customer.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商户信息数据访问层
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/28 2:03 下午
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

}
