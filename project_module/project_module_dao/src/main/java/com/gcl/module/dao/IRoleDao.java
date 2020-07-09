package com.gcl.module.dao;

import com.gcl.module.domain.Permission;
import com.gcl.module.domain.Role;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {

    //根据用户id查询出所有对应的角色
    @Select("select * from role where id in( select roleId from users_role where userId=#{userId})")
    @Results(
            {
                    @Result(id=true,column="id",property="id"),
                    @Result(column="roleName",property="roleName"),
                    @Result(column="roleDesc",property="roleDesc"),
                    @Result(column="id",property="permissions",javaType=List.class,many=@Many(select="com.gcl.module.dao.IPermissionDao.findByRoleId"))
                            })
    public List<Role> findRoleByUserId(String userId) throws Exception;

    @Select("Select * from role")
    List<Role> findAll() throws Exception;

    @Insert("Insert into role (roleName,roleDesc) values(#{roleName}, #{roleDesc})")
    void save(Role role) throws Exception;

    @Select("select * from role where id=#{roleId}")
    Role findById(int roleId) throws Exception;

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermission(int roleId);

    @Insert("INSERT INTO role_permission (permissionId, roleId) VALUES(#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("roleId") int roleId, @Param("permissionId") int permissionId);
}
