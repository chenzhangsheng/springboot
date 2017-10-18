package springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.common.ErrConstatns;
import springboot.common.exception.PlatformRequestRuntimeException;
import springboot.common.query.XinxirenUserQuery;
import springboot.dao.CityDao;
import springboot.dao.UserDo;
import springboot.dao.UserRoleDo;
import springboot.domain.UserRole;
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
    @Autowired
    private UserRoleDo userRoleDo;

    @Override
    public Object GetUserList(XinxirenUserQuery xinxirenUserQuery) {
        PageHelper.startPage(xinxirenUserQuery.getPageNo(),xinxirenUserQuery.getRowCount());
        List<XinxirenUserBean> list = userDo.GetUserList(xinxirenUserQuery);
        PageInfo page = new PageInfo(list);
        return page;
    }


    @Override
    @Transactional
    public void addUser(XinxirenUserQuery xinxirenUserQuery) {
        XinxirenUserQuery query = new XinxirenUserQuery();
        query.setAccount(xinxirenUserQuery.getAccount());
        List<XinxirenUserBean> list =userDo.GetUserList(query);
        if(list.size()>0){
            throw new PlatformRequestRuntimeException(ErrConstatns.getCodeMessage(ErrConstatns.E_ACCOUNT_ALREADY_EXIST), ErrConstatns.E_ACCOUNT_ALREADY_EXIST, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        userDo.AddUser(xinxirenUserQuery);
        UserRole userRole = new UserRole();
        userRole.setUid(xinxirenUserQuery.getId());
        userRole.setRid(xinxirenUserQuery.getRid());
        userRoleDo.AddUseRole(userRole);
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
