package com.example.carleasingclub_monolith.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zkboort
 * @since 2022-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "CustomUser对象", description = "")
public class CustomUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = " uid", type = IdType.AUTO)
    private Long  uid;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "真实姓名")
    @TableField("real_name")
    private String realName;

    @ApiModelProperty(value = "生日")
    private Integer birthday;

    @ApiModelProperty(value = "身份证号")
    @TableField("card_id")
    private String cardId;

    @ApiModelProperty(value = "用户类型")
    @TableField("user_type")
    private String userType;

    @ApiModelProperty(value = "用户备注")
    private String mark;

    @ApiModelProperty(value = "用户昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty(value = "头像地址")
    @TableField("head_portrait")
    private String headPortrait;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "添加时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "最后一次登录时间")
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty(value = "添加登录ip")
    @TableField("add_ip")
    private String addIp;

    @ApiModelProperty(value = "最后一次登录ip")
    @TableField("last_login_ip")
    private String lastLoginIp;

    @ApiModelProperty(value = "余额")
    @TableField("now_balance")
    private BigDecimal nowBalance;

    @ApiModelProperty(value = "积分")
    private BigDecimal integral;

    @ApiModelProperty(value = "用户等级")
    private Integer level;

    @ApiModelProperty(value = "用户状态 0 禁用 1启用")
    private Boolean enabled;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "用户登录类型 微信 routine h5")
    @TableField("login_type")
    private String loginType;

    @ApiModelProperty(value = "删除标记 0 删除 1未删除")
    @TableField("is_del")
    private Boolean isDel;


}
