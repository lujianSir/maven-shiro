package com.dh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.dao.RoleMapper;
import com.dh.entity.Role;
import com.dh.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> getRoles(String username) {
		// TODO Auto-generated method stub
		return roleMapper.getRoles(username);
	}

}
