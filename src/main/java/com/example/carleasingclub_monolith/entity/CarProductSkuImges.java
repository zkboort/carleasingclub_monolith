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
@ApiModel(value = "CarProductSkuImges对象", description = "")
public class CarProductSkuImges implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "销售属性id")
    @TableField("sku_id")
    private Long skuId;

    @ApiModelProperty(value = "sku图片url")
    @TableField("img_url")
    private String imgUrl;

    @TableField("img_sort")
    private Integer imgSort;

    @ApiModelProperty(value = "默认图片路径")
    @TableField("default_img")
    private String defaultImg;


}
