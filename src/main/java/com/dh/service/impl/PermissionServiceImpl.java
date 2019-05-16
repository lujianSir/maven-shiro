package com.dh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.dao.PermissionMapper;
import com.dh.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public List<String> getTheUrl(int uid) {
		// TODO Auto-generated method stub
		return permissionMapper.getTheUrl(uid);
	}

}
