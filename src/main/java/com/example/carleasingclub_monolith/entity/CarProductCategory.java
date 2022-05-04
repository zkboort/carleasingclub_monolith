package com.example.carleasingclub_monolith.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
@ApiModel(value = "CarProductCategory对象", description = "")
public class CarProductCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分类ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "父类id")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "分类级别")
    private Integer level;

    @ApiModelProperty(value = "图标地址")
    private String icon;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "商品数量")
    @TableField(value = "product_count")
    private Integer productCount;

    @ApiModelProperty(value = "计量单位")
    @TableField("product_unit")
    private String productUnit;

    @ApiModelProperty(value = "是否显示 0不显示 1显示")
    @TableField("show_status")
    private Integer showStatus;


}
