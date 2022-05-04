package com.example.carleasingclub_monolith.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
@ApiModel(value = "SysMenu对象", description = "")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "是否外链")
    @TableField("is_frame")
    private Boolean isFrame;

    @ApiModelProperty(value = "菜单名称")
    private String name;

    private String component;

    @ApiModelProperty(value = "组件名称")
    @TableField("component_name")
    private String componentName;

    @ApiModelProperty(value = "父菜单id")
    @TableField("father_id")
    private Long fatherId;

    @ApiModelProperty(value = "排序")
    private Long sort;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "链接地址")
    private String path;

    @ApiModelProperty(value = "是否缓存 布尔值")
    private Boolean cache;

    @ApiModelProperty(value = "是否隐藏 布尔值")
    private Boolean hidden;

    @ApiModelProperty(value = "权限")
    private String permission;

    private Integer type;

    @ApiModelProperty(value = "创建日期")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改日期")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "删除标记")
    @TableField("is_del")
    private Boolean isDel;


}
