package springboot.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.common.query.XinxirenUserQuery;
import springboot.dao.CityDao;
import springboot.dao.UserDo;
import springboot.domain.XinxirenUser;
import springboot.domain.bean.XinxirenUserBean;
import springboot.service.UserService;

import java.util.List;

/**
 * Created by ChenZhangsheng on 2017/10/17.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDo userDo;

    @Override
    public List<XinxirenUserBean> GetUserList(XinxirenUserQuery xinxirenUserQuery) {
        return userDo.GetUserList(xinxirenUserQuery);
    }

    @Override
    public void addUser(XinxirenUserQuery xinxirenUserQuery) {

    }

    @Override
    public int deleteUser(XinxirenUserQuery xinxirenUserQuery) {
        return 0;
    }

    @Override
    public int updateUser(@Param("userId") Long userId) {
        return 0;
    }
}
