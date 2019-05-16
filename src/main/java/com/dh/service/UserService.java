package com.dh.service;

import com.dh.entity.User;

public interface UserService {
	/**
	 * 通过用户名查询用户信息
	 * 
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);
}
