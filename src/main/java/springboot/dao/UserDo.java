package springboot.dao;

import org.apache.ibatis.annotations.Param;
import springboot.common.query.RoleQuery;
import springboot.domain.bean.XinxirenUserBean;
import springboot.common.MyMapper;
import springboot.common.query.XinxirenUserQuery;
import springboot.domain.XinxirenUser;

import java.util.List;

/**
 * Created by ChenZhangsheng on 2017/10/17.
 */
public interface UserDo extends MyMapper<XinxirenUser> {

    /**
     * 根据条件查询用户信息
     * @param xinxirenUserQuery
     */
    List<XinxirenUserBean> GetUserList(XinxirenUserQuery xinxirenUserQuery);
    /**
     * 添加账户信息
     * @param xinxirenUserQuery
     */
    void AddUser(XinxirenUserQuery xinxirenUserQuery);

    /**
     * 根据条件查询单一账户信息
     * @param xinxirenUserQuery
     */
    XinxirenUserBean SelectOne(XinxirenUserQuery xinxirenUserQuery);

    /**
     * 删除用户信息
     * @param userId
     */
    void deleteUser(@Param("userId") Long userId);

    /**
     * 修改用户信息
     * @param xinxirenUserQuery
     */
    void updateUser(XinxirenUserQuery xinxirenUserQuery);


}
