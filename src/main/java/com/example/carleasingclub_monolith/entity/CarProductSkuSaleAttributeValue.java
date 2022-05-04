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
@ApiModel(value = "CarProductSkuSaleAttributeValue对象", description = "")
public class CarProductSkuSaleAttributeValue implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "sku销售属性值 id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("sku_id")
    private Long skuId;

    @TableField("spu_id")
    private Long spuId;

    @TableField("attribute_id")
    private Integer attributeId;

    @TableField("attribute_value")
    private String attributeValue;


}
