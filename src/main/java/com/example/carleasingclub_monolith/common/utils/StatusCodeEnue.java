package com.example.carleasingclub_monolith.common.utils;

/**
 * @author chennanjiang
 * @Description: 状态码enue类型
 * @date 2022-04-27 15:09
 */
public enum StatusCodeEnue {
    LOGIN_FAIL(601,"登录失败！用户名或密码错误"),
    NO_LOGIN(401,"未登录，请登录"),
    ACCOUNT_ENABLED(605,"账号被禁用"),
    ADD_FAIL(1000,"新增失败！"),
    NO_PROMISSION(609,"权限不足！");



    private Integer code;
    private String message;


    StatusCodeEnue(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
