package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import com.cydeo.mapper.RoleMapper;
import com.cydeo.repository.RoleRepository;
import com.cydeo.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleDTO> listAllRoles() {
        List<Role>roleList = roleRepository.findAll();//I go to database, and I got entity but controller is looking for dto and to convert we use model maper
        //I have role entities from db
        //I need to convert those role entities to dto
        //i need to use modelmapper
        //i already created a class calles rolemapper and there are methods for me that will make this conversion

        return  roleList.stream().map(roleMapper::convertToDto).collect(Collectors.toList());

    }

    @Override
    public RoleDTO findById(Long id) {
       return roleMapper.convertToDto(roleRepository.findById(id).get());
    }
}

