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
@ApiModel(value = "CarProductArribute对象", description = "")
public class CarProductArribute implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品属性id")
    @TableId(value = "attribute_id", type = IdType.AUTO)
    private Integer attributeId;

    @ApiModelProperty(value = "商品三级分类id")
    @TableField("catelog_id")
    private Integer catelogId;

    @ApiModelProperty(value = "属性名称")
    @TableField("attribute_name")
    private String attributeName;

    @ApiModelProperty(value = "属性类型")
    @TableField("attribute_type")
    private String attributeType;

    @ApiModelProperty(value = "检索类型")
    @TableField("search_type")
    private String searchType;


}
