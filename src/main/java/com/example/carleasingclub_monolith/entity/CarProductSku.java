package com.example.carleasingclub_monolith.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
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
@ApiModel(value = "CarProductSku对象", description = "")
public class CarProductSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sku_id", type = IdType.AUTO)
    private Long skuId;

    @ApiModelProperty(value = "所属三级分类")
    @TableField("catelog_id")
    private Long catelogId;

    @TableField("brand_id")
    private Long brandId;

    @ApiModelProperty(value = "商品id")
    @TableField("spu_id")
    private Long spuId;

    @ApiModelProperty(value = "sku名称")
    @TableField("sku_name")
    private String skuName;

    @ApiModelProperty(value = "sku描述")
    @TableField("sku_descript")
    private String skuDescript;

    @ApiModelProperty(value = "sku默认图片url")
    @TableField("sku_default_img")
    private String skuDefaultImg;

    @ApiModelProperty(value = "sku标题")
    @TableField("sku_title")
    private String skuTitle;

    @ApiModelProperty(value = "副标题")
    @TableField("sku_subtitle")
    private String skuSubtitle;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "库存")
    @TableField("sale_count")
    private Long saleCount;


}
