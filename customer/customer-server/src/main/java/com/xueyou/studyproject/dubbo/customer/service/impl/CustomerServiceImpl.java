package com.xueyou.studyproject.dubbo.customer.service.impl;

import com.xueyou.studyproject.dubbo.base.service.impl.BaseServiceImpl;
import com.xueyou.studyproject.dubbo.customer.entity.Customer;
import com.xueyou.studyproject.dubbo.customer.mapper.CustomerMapper;
import com.xueyou.studyproject.dubbo.customer.service.CustomerService;
import org.springframework.stereotype.Service;

/**
 * 商户信息服务实现
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/28 2:06 下午
 */
@Service("customerService")
public class CustomerServiceImpl extends BaseServiceImpl<CustomerMapper, Customer> implements CustomerService {

}
