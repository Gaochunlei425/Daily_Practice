package com.gcl.module.service.impl;


import com.gcl.module.dao.IRoleDao;
import com.gcl.module.domain.Permission;
import com.gcl.module.domain.Role;
import com.gcl.module.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceimpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    public void addPermissionToRole(int roleId, int[] permissionIds) throws Exception {
        for (int permissionId: permissionIds
             ) {
            roleDao.addPermissionToRole(roleId, permissionId);
        }
    }

    public void addPermissionToRole(int roleId) throws Exception {
//        roleDao.addPermissionToRole(roleId);
    }

    public Role findById(int roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    public List<Permission> findOtherPermission(int roleId) throws Exception {
        return roleDao.findOtherPermission(roleId);
    }
}
