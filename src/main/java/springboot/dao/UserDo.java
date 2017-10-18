package springboot.dao;

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
     * 根据条件查询账户信息
     * @param xinxirenUserQuery
     */
    List<XinxirenUserBean> GetUserList(XinxirenUserQuery xinxirenUserQuery);
    /**
     * 添加账户信息
     * @param xinxirenUserQuery
     */
    void AddUser(XinxirenUserQuery xinxirenUserQuery);

}
