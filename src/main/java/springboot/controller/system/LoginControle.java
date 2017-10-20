package springboot.controller.system;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.common.*;
import springboot.common.exception.PlatformRequestRuntimeException;
import springboot.common.query.XinxirenUserQuery;
import springboot.common.utils.HttpRequestUtil;
import springboot.domain.Permission;
import springboot.domain.bean.XinxirenUserBean;
import springboot.redis.RedisClient;
import springboot.service.RoleManager;
import springboot.service.UserManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by ChenZhangsheng on 2017/10/16.
 */
@Controller
public class LoginControle extends BaseAction{
    @Autowired
    private UserManager userManager;
    @Autowired
    private RoleManager roleManager;
    @Autowired
    private RedisClient redisClient;

    @RequestMapping(value = ActionURLContstants.PRIVATE + "/" + ActionURLContstants.VERSION_V1+"/login", method = { RequestMethod.POST })
    @ResponseBody
    public Object Login(HttpServletRequest request, HttpServletResponse response){
        try{
            XinxirenUserQuery xinxirenUserQuery = HttpRequestUtil.getRequestQuerryBean(request,XinxirenUserQuery.class);
            XinxirenUserBean user = userManager.GetUser(xinxirenUserQuery);
            if(null == user){
                throw new PlatformRequestRuntimeException(ErrConstatns.getCodeMessage(ErrConstatns.E_ACCOUNT_PASSWORD_ERROR), ErrConstatns.E_ACCOUNT_PASSWORD_ERROR, HttpStatus.OK);
            }else{
               AccessTokenBean accessTokenBean = this.getToken(user.getAccount(),user.getPassword());
               log.info(Constant.PROJECT_NAME+" "+"Login "+accessTokenBean.getAccessToken());
               user.setAccessTokenBean(accessTokenBean);
               redisClient.setRedisObject(accessTokenBean.getAccessToken(),user.getAccount(),new Long(accessTokenBean.getExpiresIn()).intValue());
               List<Permission> permissionList = roleManager.GetPermissionList(user.getRole().getId());
               user.setPermissionList(permissionList);
            }
            return new ResultBean(user, ResultBean.OK, "success");
        }catch (Exception e) {
            log.error("addUser: "+e.getMessage() + "_" + ExceptionUtils.getStackTrace(e));
            BaseAction.ExceptionErrorMessage message = getExceptionErrorMessage(e);
            return new ResultBean(null, message.getErrCode(),message.getErrMsg());
        }
    }


}
