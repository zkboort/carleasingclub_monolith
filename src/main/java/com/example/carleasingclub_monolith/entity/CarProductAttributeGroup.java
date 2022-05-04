package com.example.carleasingclub_monolith.entity;

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
@ApiModel(value = "CarProductAttributeGroup对象", description = "")
public class CarProductAttributeGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "属性分组id")
    @TableId("attribute_group_id")
    private Long attributeGroupId;

    @ApiModelProperty(value = "属性分组名称")
    @TableField("attribute_group_name")
    private String attributeGroupName;

    @ApiModelProperty(value = "属性分组 所属的分类")
    @TableField("car_product_catelog_id")
    private Long carProductCatelogId;

    @ApiModelProperty(value = "属性分组的描述信息")
    @TableField("attribute_group_descript")
    private String attributeGroupDescript;

    @ApiModelProperty(value = "属性分组 排序")
    @TableField("attribute_group_sort")
    private Integer attributeGroupSort;

    @ApiModelProperty(value = "属性分组的图标 url")
    @TableField("attribute_group_icon")
    private String attributeGroupIcon;


}
