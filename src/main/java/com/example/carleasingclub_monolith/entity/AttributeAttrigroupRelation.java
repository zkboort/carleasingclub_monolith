package com.example.carleasingclub_monolith.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value = "AttributeAttrigroupRelation对象", description = "")
public class AttributeAttrigroupRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "属性id")
    @TableField("attribute_id")
    private Long attributeId;

    @ApiModelProperty(value = "属性分组 id")
    @TableField("attribute_group_id")
    private Long attributeGroupId;

    @ApiModelProperty(value = "属性排序")
    @TableField("attribute_sort")
    private Integer attributeSort;


}
