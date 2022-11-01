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
        List<Role>roleList = roleRepository.findAll();//I go to database an got entity but cotroller is loking for dto and to convert bwe use modelmaper
        //I have role enties from db
        //i nee to conver those role entoies to dtos
        //i nee to use modelmapper
        //i already created a class calles rolemapper and there are methods for me that will make this conversion

        return  roleList.stream().map(roleMapper::convertToDto).collect(Collectors.toList());

    }

    @Override
    public RoleDTO findById(Long id) {
        return null;
    }
}

