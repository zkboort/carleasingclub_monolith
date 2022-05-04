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
@ApiModel(value = "CarProductSpu对象", description = "")
public class CarProductSpu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
    @TableId(value = "spu_id", type = IdType.AUTO)
    private Long spuId;

    @ApiModelProperty(value = "所属分类")
    @TableField("catelog_id")
    private Long catelogId;

    @ApiModelProperty(value = "所属品牌")
    @TableField("brand_id")
    private Long brandId;

    @ApiModelProperty(value = "商品名称")
    @TableField("spu_name")
    private String spuName;

    @ApiModelProperty(value = "商品描述")
    @TableField("spu_description")
    private String spuDescription;

    @ApiModelProperty(value = "商品重量")
    private Double weight;

    @ApiModelProperty(value = "上架状态")
    @TableField("publish_status")
    private String publishStatus;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
