package com.dh.dao;

import java.util.List;

import com.dh.entity.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

	/**
	 * 通过角色ID查询对应的权限
	 * 
	 * @param rid
	 * @return
	 */
	List<String> getTheUrl(int uid);
}