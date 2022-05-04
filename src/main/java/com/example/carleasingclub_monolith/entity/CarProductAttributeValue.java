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
@ApiModel(value = "CarProductAttributeValue对象", description = "")
public class CarProductAttributeValue implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商品id")
    @TableField("spu_id")
    private Long spuId;

    @ApiModelProperty(value = "商品属性ID")
    @TableField("car_product_attribute_id")
    private Long carProductAttributeId;

    @ApiModelProperty(value = "商品名称")
    @TableField("car_product_attribute_name")
    private String carProductAttributeName;

    @ApiModelProperty(value = "商品属性值")
    @TableField("car_product_attribute_value")
    private String carProductAttributeValue;

    @ApiModelProperty(value = "属性排序")
    @TableField("car_product_attribute_sort")
    private String carProductAttributeSort;

    @ApiModelProperty(value = "是否显示 0 不显示 1显示")
    @TableField("quick_show")
    private Boolean quickShow;


}
