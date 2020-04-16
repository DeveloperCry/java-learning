package com.learning.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Role {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private String status;
    private String remark;
    private Date createDate;
    private Long createUser;
    private Date editDate;
    private Long editUser;

}