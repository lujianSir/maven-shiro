package com.dh.dao;

import java.util.List;

import com.dh.entity.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

	/**
	 * 通过名称查询用户的角色
	 * 
	 * @param username
	 * @return
	 */
	List<Role> getRoles(String username);
}