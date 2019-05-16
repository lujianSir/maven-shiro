package com.dh.dao;

import com.dh.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	/**
	 * 通过用户名查询用户信息
	 * 
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);
}