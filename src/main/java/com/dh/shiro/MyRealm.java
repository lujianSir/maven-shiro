package com.dh.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.dh.entity.Role;
import com.dh.entity.User;
import com.dh.service.PermissionService;
import com.dh.service.RoleService;
import com.dh.service.UserService;

public class MyRealm extends AuthorizingRealm {

	@Autowired
	private PermissionService permissionService;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

		// 获取登录时输入的用户名
		String username = (String) principalCollection.getPrimaryPrincipal();

		if (username != null) {
			// 获取用户信息
			User user = userService.getUserByUsername(username);
			// 获取用户角色
			List<Role> roles = roleService.getRoles(username);
			// 获取权限列表
			List<String> permission = permissionService.getTheUrl(user.getId());

			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

			if (permission != null && !permission.isEmpty()) {
				for (String url : permission) {
					info.addStringPermission(url);// 加入权限
				}
			}
			if (roles != null && !roles.isEmpty()) {
				for (Role role : roles) {
					info.addRole(role.getRole());// 加入角色
				}
			}
			return info;
		}
		return null;
	}

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		// 通过表单接收的用户名
		String username = token.getUsername();
		System.out.println("username:" + username);
		if (username != null && !"".equals(username)) {
			User user = userService.getUserByUsername(username);
			if (user != null) {
				return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
			}
		}
		System.out.println("认证失败");
		return null;
	}


}
