package springboot.service;

import org.apache.ibatis.annotations.Param;
import springboot.common.query.XinxirenUserQuery;
import springboot.domain.XinxirenUser;
import springboot.domain.bean.XinxirenUserBean;

import java.util.List;
import java.util.Map;

/**
 * Created by ChenZhangsheng on 2017/10/16.
 */
public interface UserService {


    /**
     * 根据条件查询账户信息
     * @param xinxirenUserQuery
     */
    List<XinxirenUserBean> GetUserList(XinxirenUserQuery xinxirenUserQuery);
    /**
     * 添加用户信息
     * @param xinxirenUserQuery
     */
    void addUser(XinxirenUserQuery xinxirenUserQuery);

    /**
     * 删除用户信息
     * @param xinxirenUserQuery
     */
    int deleteUser(XinxirenUserQuery xinxirenUserQuery);

    /**
     * 修改用户信息
     * @param userId
     */
    int updateUser(@Param("userId") Long userId);

}
