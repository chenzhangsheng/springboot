package springboot.service;

import springboot.common.query.XinxirenUserQuery;
import springboot.domain.XinxirenUser;

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
    List<XinxirenUser> GetUserList(XinxirenUserQuery xinxirenUserQuery);

    void addUser(XinxirenUserQuery xinxirenUserQuery);

}
