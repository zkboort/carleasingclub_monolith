package com.example.carleasingclub_monolith.common.result;/**
 * @Description:
 * @author chennanjiang
 * @date 2022-04-27 11:31
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chennanjiang
 * @date Created in 2022/4/27 11:31
 * @description 全局统一响应类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response implements Serializable {
    private static final long serialVersionUID=1L;

    private Integer code;
    private String msg;
    private Object data;

    /***
     * @Description
     * @author chennanjiang
     * @date 2022/4/27 14:56
     * @params [message]
     * @return com.example.carleasingclub_monolith.common.result.Response
     */
    public static Response success(String message){
        return new Response(200,message,null);
    }
    public static Response success(String message, Object data){
        return new Response(200,message,data);
    }

    /***
     * @Description 错误返回结果
     * @author chennanjiang
     * @date 2022/4/27 14:57
     * @params []
     * @return com.example.carleasingclub_monolith.common.result.Response
     */
    public static Response error(Integer code,String message){
        return new Response(code,message,null);
    }
    public static Response error(String message){
       return new Response(500,message,null);
    }

    public Response error(String message, Object data){
        return new Response(500,message,data);
    }


}
