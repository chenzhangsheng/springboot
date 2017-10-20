package springboot.dao;

import org.apache.ibatis.annotations.Param;
import springboot.common.MyMapper;
import springboot.common.query.RoleQuery;
import springboot.common.query.UserRoleQuery;
import springboot.common.query.XinxirenUserQuery;
import springboot.domain.Permission;
import springboot.domain.Role;
import springboot.domain.bean.XinxirenUserBean;

import java.util.List;

/**
 * Created by zhangshengchen on 2017/10/19.
 */
public interface RoleDo extends MyMapper<Role> {
    /**
     * 根据条件查询角色组信息
     * @param roleQuery
     */
    List<Role> GetRoleList(RoleQuery roleQuery);
    /**
     * 添加角色信息
     * @param roleQuery
     */
    void addRole(RoleQuery roleQuery);

    /**
     * 删除角色信息
     * @param roleId
     */
    void deleteRole(@Param("roleId") Long roleId);

    /**
     * 修改角色信息
     * @param roleQuery
     */
    void updateRole(RoleQuery roleQuery);

    /**
     * 根据条件查询角色所在资源组信息
     * @param roleId
     */
    List<Permission> GetPermissionList(@Param("roleId") Long roleId);

    /**
     * 删除角色资源组信息
     * @param roleId
     */
    void deletePermissionList(@Param("roleId") Long roleId);

    /**
     * 添加角色资源组信息
     * @param roleQuery
     */
    void addPermissionList(RoleQuery roleQuery);
}
