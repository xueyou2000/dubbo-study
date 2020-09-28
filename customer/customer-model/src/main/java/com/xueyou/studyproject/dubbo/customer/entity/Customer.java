package com.xueyou.studyproject.dubbo.customer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Version;
import java.time.LocalDateTime;

/**
 * 商户信息
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/28 1:13 下午
 */
@Data
@TableName("customer")
@ApiModel(value = "Customer", description = "商户信息")
public class Customer {

    /**
     * 商户id
     */
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "商户id")
    private Long customerId;

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
     * 商户全称
     */
    @ApiModelProperty(value = "商户全称")
    private String fullName;

    /**
     * 商户简称
     */
    @ApiModelProperty(value = "商户简称")
    private String sortName;

    /**
     * 营业地址
     */
    @ApiModelProperty(value = "营业地址")
    private String businessAddress;

    /**
     * 联系人名称
     */
    @ApiModelProperty(value = "联系人名称")
    private String linkName;

    /**
     * 联系人手机号
     */
    @ApiModelProperty(value = "联系人手机号")
    private String linkPhone;


}
