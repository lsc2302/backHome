package com.lsc.backhome.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Site implements Serializable {
    private static final long serialVersionUID = 6462327373830253581L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "address")
    private String address;

    @TableField(value = "fees")
    private String fees;

    @TableField(value = "hours")
    private String hours;

    @TableField(value = "appointment")
    private String appointment;

    @TableField(value = "report_to")
    private String reportTo;

    @TableField(value = "show_IGG")
    private String showIGG;

    @TableField(value = "N_protein_test")
    private String NProteinTest;

    @TableField(value = "wechat_num")
    private String contactWeChat;

    @TableField(value = "phone_num")
    private String contactPhone;

    @TableField(value = "email")
    private String contactEmail;

    @TableField(value = "web")
    private String contactWeb;

}
