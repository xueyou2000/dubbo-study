package com.xueyou.studyproject.dubbo.common.dto.query;

import com.xueyou.studyproject.dubbo.common.enums.SortDirection;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * 通用查询对象
 */
@Data
public class QueryBaseDto {

    /**
     * 排序方向
     */
    private SortDirection direction = SortDirection.DESC;

    /**
     * 排序字段
     */
    private List<String> sortNames = Collections.singletonList("createTime");

    /**
     * 日期范围查询
     */
    private List<DateRange> dateRanges;

    /**
     * 数值范围查询
     */
    private List<NumberRange> numberRanges;

    /**
     * 模糊查询
     */
    private List<FuzzyMatch> fuzzyMatches;

    /**
     * 多值搜索
     */
    private List<MultiMatch> multiValues;

}
