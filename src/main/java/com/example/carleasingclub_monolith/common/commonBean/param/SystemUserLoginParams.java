package com.example.carleasingclub_monolith.common.commonBean.param;/**
 * @Description:
 * @author chennanjiang
 * @date 2022-05-03 17:04
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author chennanjiang
 * @date Created in 2022/5/3 17:04
 * @description 登录参数封装类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "系统用户登录参数封装")
public class SystemUserLoginParams {
    @ApiModelProperty(value = "用户名",required = true)
    private String username;
    @ApiModelProperty(value = "密码",required = true)
    private String password;
    @ApiModelProperty(value = "验证码",required = true)
    private String verifyCode;
}
