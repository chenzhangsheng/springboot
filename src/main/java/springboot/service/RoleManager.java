package springboot.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springboot.common.query.RoleQuery;
import springboot.dao.RoleDo;
import springboot.domain.Permission;
import springboot.domain.Role;

import java.util.List;

/**
 * Created by zhangshengchen on 2017/10/20.
 */
@Repository("roleManager")
public class RoleManager {

    @Autowired
    private RoleDo roleDo;

    public Object GetRoleList(RoleQuery roleQuery) {
        List<Role> list = roleDo.GetRoleList(roleQuery);
        return list;
    }

    public void addRole(RoleQuery roleQuery) {
        roleDo.addRole(roleQuery);
    }

    public void deleteRole(@Param("roleId") Long roleId) {
        roleDo.deleteRole(roleId);
    }

    public void updateRole(RoleQuery roleQuery) {
        roleDo.updateRole(roleQuery);
    }

    @Transactional
    public void updatePermission(RoleQuery roleQuery) {
        //先删除再添加
        roleDo.deletePermissionList(roleQuery.getId());
        roleDo.addPermissionList(roleQuery);
    }
    public List<Permission> GetPermissionList(@Param("roleId") Long roleId) {
        return roleDo.GetPermissionList(roleId);
    }
}
