package com.dh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.dao.UserMapper;
import com.dh.entity.User;
import com.dh.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userMapper.getUserByUsername(username);
	}

}
