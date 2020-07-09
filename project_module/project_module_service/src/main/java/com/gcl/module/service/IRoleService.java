package com.gcl.module.service;



import com.gcl.module.domain.Permission;
import com.gcl.module.domain.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    void addPermissionToRole(int roleId, int[] permissionIds) throws Exception;

    Role findById(int roleId) throws  Exception;

    List<Permission> findOtherPermission(int roleId) throws Exception;
}
