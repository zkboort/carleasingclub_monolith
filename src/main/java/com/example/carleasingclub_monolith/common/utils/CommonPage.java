package com.example.carleasingclub_monolith.common.utils;/**
 * @Description:
 * @author chennanjiang
 * @date 2022-05-01 14:29
 */

import io.swagger.models.auth.In;

import java.util.List;

/**
 * @author chennanjiang
 * @date Created in 2022/5/1 14:29
 * @description 分页数据封装
 */
public class CommonPage<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;
}