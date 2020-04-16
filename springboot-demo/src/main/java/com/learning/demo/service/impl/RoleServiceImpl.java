package com.learning.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learning.demo.convertor.role.RoleDtoConverter;
import com.learning.demo.dao.RoleDao;
import com.learning.demo.dto.role.RoleDto;
import com.learning.demo.entity.Role;
import com.learning.demo.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

    @Autowired
    private RoleDtoConverter roleDtoConverter;

    public boolean save(RoleDto roleDto, Long editUser) {
        Role role = this.roleDtoConverter.toEntity(roleDto);

        role.setCreateDate(new Date());
        role.setEditDate(new Date());
        role.setCreateUser(editUser);
        role.setEditUser(editUser);
        return super.save(role);
    }

    @Override
    public boolean update(RoleDto roleDto, Long roleId, Long editUserId) {
        Role role = this.roleDtoConverter.toEntity(roleDto);

        role.setEditDate(new Date());
        role.setEditUser(editUserId);
        role.setId(roleId);
        return super.updateById(role);
    }
}
