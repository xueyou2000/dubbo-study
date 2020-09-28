package com.xueyou.studyproject.dubbo.customer.dto;

import com.xueyou.studyproject.dubbo.common.dto.BaseQueryDto;
import com.xueyou.studyproject.dubbo.customer.entity.Customer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商户查询实体
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/28 2:11 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "CustomerQueryDto", description = "商户查询")
public class CustomerQueryDto extends BaseQueryDto implements Serializable {

    /**
     * 商户信息
     */
    @ApiModelProperty(value = "商户信息")
    private Customer customer = new Customer();

}
