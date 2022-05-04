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
@ApiModel(value = "Picture对象", description = "")
public class Picture implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "上传时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "删除的url")
    @TableField("delete_url")
    private String deleteUrl;

    @ApiModelProperty(value = "图片名称")
    @TableField("picture_name")
    private String pictureName;

    @ApiModelProperty(value = "图片高度")
    private String height;

    @ApiModelProperty(value = "图片宽度")
    private String width;

    @ApiModelProperty(value = "图片大小")
    private String size;

    @ApiModelProperty(value = "图片地址")
    private String url;

    private String username;

    @ApiModelProperty(value = "文件的MD5值")
    private String md5code;


}
