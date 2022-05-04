package com.example.carleasingclub_monolith.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
@ApiModel(value = "SystemUser对象", description = "")
public class SystemUser implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户表")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "头像地址")
    @TableField("head_portrait")
    private String headPortrait;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "最后一次修改密码时间")
    @TableField("last_password_reset_time")
    private LocalDateTime lastPasswordResetTime;

    @ApiModelProperty(value = "系统用户状态 0 禁用 1启用")
    private Integer enabled;

    @ApiModelProperty(value = "删除标记  0 删除 1启用")
    @TableField(" is_del")
    private Boolean  isDel;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled==0;
    }
}
