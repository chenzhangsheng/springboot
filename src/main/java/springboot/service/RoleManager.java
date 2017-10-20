package springboot.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import springboot.common.ErrConstatns;
import springboot.common.exception.PlatformRequestRuntimeException;
import springboot.common.query.RoleQuery;
import springboot.common.query.XinxirenUserQuery;
import springboot.dao.RoleDo;
import springboot.dao.UserDo;
import springboot.domain.Permission;
import springboot.domain.Role;
import springboot.domain.bean.XinxirenUserBean;

import java.util.List;

/**
 * Created by zhangshengchen on 2017/10/20.
 */
@Repository("roleManager")
public class RoleManager {

    @Autowired
    private RoleDo roleDo;
    @Autowired
    private UserDo userDo;


    public List<Role> GetRoleList(RoleQuery roleQuery) {
        List<Role> list = roleDo.GetRoleList(roleQuery);
        return list;
    }

    public void addRole(RoleQuery roleQuery) {
        roleDo.addRole(roleQuery);
    }

    public void deleteRole(@Param("roleId") Long roleId) {
        XinxirenUserQuery xinxirenUserQuery = new XinxirenUserQuery();
        xinxirenUserQuery.setRid(roleId);
        List<XinxirenUserBean> list = userDo.GetUserList(xinxirenUserQuery);
        if(list.size()>0){
            throw new PlatformRequestRuntimeException(ErrConstatns.getCodeMessage(ErrConstatns.API3_ACCOUNT_EXIST), ErrConstatns.API3_ACCOUNT_EXIST, HttpStatus.OK);
        }
        roleDo.deleteRole(roleId);
    }

    public void updateRole(RoleQuery roleQuery) {
        roleDo.updateRole(roleQuery);
    }

    public List<Permission> GetPermissionList(Long rid){
        Role role = roleDo.GetRole(rid);
        return roleDo.GetPermissionList(role);
    }

}
