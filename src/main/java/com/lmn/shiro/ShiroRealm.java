package com.lmn.shiro;

import com.lmn.modules.system.user.dto.UserDTO;
import com.lmn.modules.system.user.service.UserService;
import com.lmn.modules.system.user.service.impl.UserServiceImpl;
import com.lmn.utils.Encodes;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2018/8/9.
 */
public class ShiroRealm extends AuthorizingRealm {
    // 用户对应的角色信息与权限信息都保存在数据库中，通过UserService获取数据
    @Autowired
    private UserService userService = new UserServiceImpl();

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 根据用户名查询当前用户拥有的角色
        UserDTO user = userService.getUser(username);
        // 将角色名称提供给info
        authorizationInfo.addRole(user.getRole());
        // 根据用户名查询当前用户权限
        List<String> permissions = userService.findPermissions(user.getRole());
        for (String permission : permissions) {
            authorizationInfo.addStringPermission(permission);
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        UserDTO user = userService.getUser(username);
        if (user == null) {
            // 用户名不存在抛出异常
            throw new UnknownAccountException();
        }
        if ("1".equals(user.getLocked())) {
            // 用户被管理员锁定抛出异常
            throw new LockedAccountException();
        }
        byte[] salt = Encodes.decodeHex(user.getPassword().substring(0, 16));
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(),
                user.getPassword(), ByteSource.Util.bytes(salt), getName());
        return authenticationInfo;
    }
}
