package com.xueyou.studyproject.dubbo.base.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xueyou.studyproject.dubbo.common.dto.query.*;
import com.xueyou.studyproject.dubbo.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 查询工具
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/28 11:19 上午
 */
@Slf4j
public class QueryUtils {

    /**
     * 动态拼接条件
     *
     * @param data
     * @param queryBaseDto
     * @param <T>
     * @return
     */
    public static <T> QueryWrapper<T> createPredicate(T data, QueryBaseDto queryBaseDto) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();

        // 值全等匹配查询
        Field[] fields = data.getClass().getDeclaredFields();
        for (Field field : fields) {
            // 设置字段可见
            field.setAccessible(true);
            try {
                Object val = field.get(data);
                if (val == null || StringUtils.isEmpty(val) || "version".equals(field.getName())) {
                    continue;
                }
                queryWrapper = queryWrapper.eq(StringUtil.camelToUnderline(field.getName()),val);
            } catch (IllegalAccessException e) {
                log.error("createPredicate获取字段值异常, 数据=[{}], 字段=[{}]", data, field.getName());
            }
        }

        // 日期范围查询
        if (queryBaseDto != null && queryBaseDto.getDateRanges() != null) {
            List<DateRange> dateRanges = queryBaseDto.getDateRanges();
            for (DateRange dateRange : dateRanges) {
                String columnsField = StringUtil.camelToUnderline(dateRange.getColumnsField());
                LocalDateTime startDate = dateRange.getStartDate();
                LocalDateTime endDate = dateRange.getEndDate();

                if (!StringUtils.isEmpty(columnsField)) {
                    queryWrapper = queryWrapper.between(columnsField, startDate, endDate);
                }
            }
        }

        // 数值范围查询
        if (queryBaseDto != null && queryBaseDto.getNumberRanges() != null) {
            List<NumberRange> numberRanges = queryBaseDto.getNumberRanges();
            for (NumberRange numberRange : numberRanges) {
                String columnsField = StringUtil.camelToUnderline(numberRange.getColumnsField());
                Double min = numberRange.getMin();
                Double max = numberRange.getMax();

                if (min == null) {
                    min = 0D;
                }
                if (max == null) {
                    max = 9999999D;
                }

                if (!StringUtils.isEmpty(columnsField)) {
                    queryWrapper = queryWrapper.between(columnsField, min, max);
                }
            }
        }

        // 模糊查询
        if (queryBaseDto != null && queryBaseDto.getFuzzyMatches() != null) {
            List<FuzzyMatch> fuzzyMatches = queryBaseDto.getFuzzyMatches();
            for (FuzzyMatch fuzzyMatch : fuzzyMatches) {
                String columnsField = StringUtil.camelToUnderline(fuzzyMatch.getColumnsField());
                String value = fuzzyMatch.getValue();
                if (!StringUtils.isEmpty(columnsField) && !StringUtils.isEmpty(value)) {
                    queryWrapper = queryWrapper.like(columnsField, value);
                }
            }
        }

        // 多值查询
        if (queryBaseDto != null && queryBaseDto.getMultiValues() != null) {
            List<MultiMatch> multivalues = queryBaseDto.getMultiValues();
            for (MultiMatch multiMatch : multivalues) {
                String columnsField = StringUtil.camelToUnderline(multiMatch.getColumnsField());
                List<String> values = multiMatch.getValue();
                queryWrapper = queryWrapper.in(columnsField, values);
            }

        }

        return queryWrapper;
    }




}
