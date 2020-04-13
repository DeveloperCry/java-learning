package com.learning.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Account {
    //这里主键要设置为数据自增即IdType.AUTO，如果设置为IdType.INPUT或IdType.NONE或其他的，将不能获取到主键，或者不能更新数据
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;
    private Boolean status;
    private String avatar;
    private String idCard;

    private Date createDate;
    private Long createUser;
    private Date editDate;
    private Long editUser;

}
