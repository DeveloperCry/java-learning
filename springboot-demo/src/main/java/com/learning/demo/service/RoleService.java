package com.learning.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learning.demo.dto.role.RoleDto;
import com.learning.demo.entity.Role;

public interface RoleService extends IService<Role> {
    boolean save(RoleDto roleDto, Long editUser);
    boolean update(RoleDto roleDto, Long roleId, Long editUserId);
}
