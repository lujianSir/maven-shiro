package com.dh.service;

import java.util.List;

public interface PermissionService {
	/**
	 * 通过角色ID查询对应的权限
	 * 
	 * @param rid
	 * @return
	 */
	List<String> getTheUrl(int uid);
}
