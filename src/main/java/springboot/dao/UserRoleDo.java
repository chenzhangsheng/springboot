package springboot.dao;

import org.apache.ibatis.annotations.Param;
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
    /**
     * 更新账户信息
     * @param userRole
     */
    void updateUseRole(UserRole userRole);

    /**
     * 删除账户信息
     * @param userId
     */
    void deleteUserRole(@Param("userId") Long userId);
}
