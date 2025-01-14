package com.wang.dao;

import com.wang.entity.SysUser;
import com.wang.vo.UserVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysUserMapper {
    /**
     * 根据用户名查询用户信息
     *
     * @param userName
     * @return
     */
    SysUser fidUserByUserName(String userName);

    /**
     * 根据部门编号查询该部门下的员工信息
     *
     * @param deptId
     * @return
     */
    @Select("select count(1) from sys_user where deptId = #{deptId}")
    int getUserCountByDeptId(Integer deptId);

    /**
     * 根据角色编号查询该角色下的用户数量
     * @param roleId
     * @return
     */
    @Select("select count(1) from sys_user_role t1 inner join sys_user t2 on t2.id = t1.uid where t1.rid = #{roleId}")
    int getUserCountByRoleId(Integer roleId);

    /**
     *查询用户列表
     * @param userVo
     * @return
     */
    List<SysUser>findUserList(UserVo userVo);

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);


}