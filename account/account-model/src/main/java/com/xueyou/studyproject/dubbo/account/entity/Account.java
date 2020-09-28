package com.xueyou.studyproject.dubbo.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xueyou.studyproject.dubbo.account.enums.AccountStatus;
import com.xueyou.studyproject.dubbo.account.enums.AccountType;
import com.xueyou.studyproject.dubbo.common.enums.UserType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Version;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 账户信息
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/25 12:53 下午
 */
@Data
@TableName("account")
@ApiModel(value = "Account", description = "账户信息")
public class Account implements Serializable {

    /**
     * 账户id
     */
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "账户Id")
    private Long accountId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     * 上次修改此实体的时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    /**
     * 乐观锁
     */
    @Version
    private Integer version;

    /**
     * 账户类型
     */
    @ApiModelProperty(value = "账户类型")
    private AccountType accountType;

    /**
     * 账户状态
     */
    @ApiModelProperty(value = "账户状态")
    private AccountStatus accountStatus;

    /**
     * 账户余额
     * 账户可用余额 = 账户余额  - (在途 + 冻结)
     */
    @ApiModelProperty(value = "账户余额")
    private Double balance;

    /**
     * 在途金额
     */
    @ApiModelProperty(value = "在途金额")
    private Double transitBal;

    /**
     * 冻结金额
     */
    @ApiModelProperty(value = "冻结金额")
    private Double freezeBal;

    /**
     * 用户ID
     * 指定此账户输入哪个用户
     */
    @ApiModelProperty(value = "用户ID")
    private Long userId;

    /**
     * 用户类型
     */
    @ApiModelProperty(value = "用户类型")
    private UserType userType;

}
