package com.learning.demo.convertor.role;

import com.learning.demo.convertor.BaseConverter;
import com.learning.demo.dto.role.RoleDto;
import com.learning.demo.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleDtoConverter extends BaseConverter<RoleDto, Role> {
}
