package com.xueyou.studyproject.dubbo.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xueyou.studyproject.dubbo.account.dto.AccountQueryDto;
import com.xueyou.studyproject.dubbo.account.entity.Account;
import com.xueyou.studyproject.dubbo.base.service.BaseService;
import com.xueyou.studyproject.dubbo.base.utils.QueryUtils;
import com.xueyou.studyproject.dubbo.common.dto.query.QueryBaseDto;

/**
 * 基础Service实现
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/28 9:25 上午
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {


    /**
     * 分页查询(单表)
     *
     * @param page     分页信息
     * @param data     查询实体信息
     * @param queryDto 查询高级信息
     */
    @Override
    public IPage<T> queryByPage(IPage<T> page, T data, QueryBaseDto queryDto) {
        QueryWrapper<T> queryWrapper = QueryUtils.createPredicate(data, queryDto);
        return page(page,queryWrapper);
    }

    /**
     * 分页查询(单表)
     *
     * @param page 分页信息
     * @param data 查询实体信息
     */
    @Override
    public IPage<T> queryByPage(IPage<T> page, T data) {
        return queryByPage(page, data, new QueryBaseDto());
    }
}
