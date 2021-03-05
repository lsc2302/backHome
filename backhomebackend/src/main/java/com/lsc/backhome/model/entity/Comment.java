package com.lsc.backhome.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @TableField(value = "content")
    private String content;


    @TableField("user_id")
    private String userId;

    @TableField("site_id")
    private Integer siteId;


    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField("stars")
    private int stars;

}
