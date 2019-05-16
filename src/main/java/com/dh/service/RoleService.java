package com.dh.service;

import java.util.List;

import com.dh.entity.Role;

public interface RoleService {
	/**
	 * 通过名称查询用户的角色
	 * 
	 * @param username
	 * @return
	 */
	List<Role> getRoles(String username);
}
