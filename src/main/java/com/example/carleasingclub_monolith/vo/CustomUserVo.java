package com.example.carleasingclub_monolith.vo;/**
 * @Description:
 * @author chennanjiang
 * @date 2022-04-27 17:08
 */

import lombok.Data;

/**
 * @author chennanjiang
 * @date Created in 2022/4/27 17:08
 * @description 系统用户操作返回视图
 */
@Data
public class CustomUserVo {
    private String  nickName;
    private String  userName;
    private String  passWord;
    private String  realName;
    private String  cardId;
    private String  phone;
    private String  headPortrait;
    private String  address;

}
