package com.lmn.modules.system.user.service;

import com.lmn.modules.system.user.dto.RoleDTO;
import com.lmn.modules.system.user.dto.UserDTO;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2018/7/30.
 */
public interface UserService {
    List queryList();

    Set<RoleDTO> findRoles(String username);

    List findPermissions(String username);

    UserDTO getUser(String username);
}
