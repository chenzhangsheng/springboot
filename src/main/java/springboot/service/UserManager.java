package springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springboot.common.ErrConstatns;
import springboot.common.exception.PlatformRequestRuntimeException;
import springboot.common.query.XinxirenUserQuery;
import springboot.dao.UserDo;
import springboot.domain.bean.XinxirenUserBean;

import java.util.List;

/**
 * Created by zhangshengchen on 2017/10/20.
 */
@Repository("userManager")
public class UserManager {

    @Autowired
    private UserDo userDo;

    public Object GetUserList(XinxirenUserQuery xinxirenUserQuery) {
        PageHelper.startPage(xinxirenUserQuery.getPageNo(),xinxirenUserQuery.getRowCount());
        List<XinxirenUserBean> list = userDo.GetUserList(xinxirenUserQuery);
        PageInfo page = new PageInfo(list);
        return page;
    }

    public void addUser(XinxirenUserQuery xinxirenUserQuery) {
        XinxirenUserQuery query = new XinxirenUserQuery();
        query.setAccount(xinxirenUserQuery.getAccount());
        XinxirenUserBean user  =userDo.SelectOne(query);
        if(user!=null){
            throw new PlatformRequestRuntimeException(ErrConstatns.getCodeMessage(ErrConstatns.E_ACCOUNT_ALREADY_EXIST), ErrConstatns.E_ACCOUNT_ALREADY_EXIST, HttpStatus.OK);
        }
        userDo.AddUser(xinxirenUserQuery);
    }


    public void deleteUser(@Param("userId") Long userId) {
        userDo.deleteUser(userId);
    }


    @Transactional
    public void updateUser(XinxirenUserQuery xinxirenUserQuery) {
        if(xinxirenUserQuery.getRid() == null || xinxirenUserQuery.getId() == null){
            throw new PlatformRequestRuntimeException(ErrConstatns.getCodeMessage(ErrConstatns.API3_PARAMETER_ERROR), ErrConstatns.API3_PARAMETER_ERROR, HttpStatus.OK);
        }
        userDo.updateUser(xinxirenUserQuery);
    }

    public XinxirenUserBean GetUser(XinxirenUserQuery xinxirenUserQuery) {
        XinxirenUserBean user  = userDo.SelectOne(xinxirenUserQuery);
        return user;
    }
}
