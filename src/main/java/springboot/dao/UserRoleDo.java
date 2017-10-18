package springboot.dao;

import springboot.common.MyMapper;
import springboot.common.query.XinxirenUserQuery;
import springboot.domain.UserRole;

/**
 * Created by zhangshengchen on 2017/10/18.
 */
public interface UserRoleDo extends MyMapper<UserRole> {
    /**
     * 添加账户信息
     * @param userRole
     */
    void AddUseRole(UserRole userRole);
}
