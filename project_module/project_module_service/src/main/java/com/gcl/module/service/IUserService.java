package com.gcl.module.service;


import com.gcl.module.domain.Role;
import com.gcl.module.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(Integer id) throws Exception;

    List<Role> findOtherRoles(Integer userid) throws Exception;

    void addRoleToUser(Integer userId, int[] roleIds) throws Exception;
}
