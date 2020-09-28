package com.xueyou.studyproject.dubbo.account.dto;

import com.xueyou.studyproject.dubbo.account.entity.Account;
import com.xueyou.studyproject.dubbo.common.dto.BaseQueryDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 账户实体查询
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/28 11:43 上午
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "AccountQueryDto", description = "账户查询")
public class AccountQueryDto extends BaseQueryDto implements Serializable {

    /**
     * 账户信息
     */
    @ApiModelProperty(value = "账户信息")
    private Account account = new Account();

}
