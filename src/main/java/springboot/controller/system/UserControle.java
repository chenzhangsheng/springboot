package springboot.controller.system;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.common.ActionURLContstants;
import springboot.common.BaseAction;
import springboot.common.ErrConstatns;
import springboot.common.ResultBean;
import springboot.common.exception.PlatformRequestRuntimeException;
import springboot.common.query.XinxirenUserQuery;
import springboot.common.utils.HttpRequestUtil;
import springboot.service.UserManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ChenZhangsheng on 2017/10/17.
 */
@Controller
public class UserControle extends BaseAction{

    @Autowired
    private UserManager userManager;

    @RequestMapping(value = ActionURLContstants.PRIVATE + "/" + ActionURLContstants.VERSION_V1+"/getUserList", method = { RequestMethod.POST ,RequestMethod.GET})
    @ResponseBody
    public Object GetUserList(HttpServletRequest request, HttpServletResponse response){
        try{
            XinxirenUserQuery xinxirenUserQuery = HttpRequestUtil.getRequestQuerryBean(request,XinxirenUserQuery.class);
            return new ResultBean(userManager.GetUserList(xinxirenUserQuery), ResultBean.OK, "success");
        }catch (Exception e) {
            log.error("getUserList: "+e.getMessage() + "_" + ExceptionUtils.getStackTrace(e));
            ExceptionErrorMessage message = getExceptionErrorMessage(e);
            return new ResultBean(null, message.getErrCode(),message.getErrMsg());
        }
    }

    @RequestMapping(value = ActionURLContstants.PRIVATE + "/" + ActionURLContstants.VERSION_V1+"/addUser", method = { RequestMethod.POST })
    @ResponseBody
    public Object AddUser(HttpServletRequest request, HttpServletResponse response){
        try{
            XinxirenUserQuery xinxirenUserQuery = HttpRequestUtil.getRequestQuerryBean(request,XinxirenUserQuery.class);
            userManager.addUser(xinxirenUserQuery);
            return new ResultBean("", ResultBean.OK, "success");
        }catch (Exception e) {
            log.error("addUser: "+e.getMessage() + "_" + ExceptionUtils.getStackTrace(e));
            ExceptionErrorMessage message = getExceptionErrorMessage(e);
            return new ResultBean(null, message.getErrCode(),message.getErrMsg());
        }
    }

    @RequestMapping(value = ActionURLContstants.PRIVATE + "/" + ActionURLContstants.VERSION_V1+"/deleteUser", method = { RequestMethod.POST })
    @ResponseBody
    public Object deleteUser(HttpServletRequest request, HttpServletResponse response){
        try{
            XinxirenUserQuery xinxirenUserQuery = HttpRequestUtil.getRequestQuerryBean(request,XinxirenUserQuery.class);
            if(xinxirenUserQuery.getId()==null){
                throw new PlatformRequestRuntimeException(ErrConstatns.getCodeMessage(ErrConstatns.API3_PARAMETER_ERROR), ErrConstatns.API3_PARAMETER_ERROR, HttpStatus.OK);
            }
            userManager.deleteUser(xinxirenUserQuery.getId());
            return new ResultBean("", ResultBean.OK, "success");
        }catch (Exception e) {
            log.error("addUser: "+e.getMessage() + "_" + ExceptionUtils.getStackTrace(e));
            ExceptionErrorMessage message = getExceptionErrorMessage(e);
            return new ResultBean(null, message.getErrCode(),message.getErrMsg());
        }
    }

    @RequestMapping(value = ActionURLContstants.PRIVATE + "/" + ActionURLContstants.VERSION_V1+"/updateUser", method = { RequestMethod.POST })
    @ResponseBody
    public Object updateUser(HttpServletRequest request, HttpServletResponse response){
        try{
            XinxirenUserQuery xinxirenUserQuery = HttpRequestUtil.getRequestQuerryBean(request,XinxirenUserQuery.class);
            if(xinxirenUserQuery.getId()==null){
                throw new PlatformRequestRuntimeException(ErrConstatns.getCodeMessage(ErrConstatns.API3_PARAMETER_ERROR), ErrConstatns.API3_PARAMETER_ERROR, HttpStatus.OK);
            }
            userManager.updateUser(xinxirenUserQuery);
            return new ResultBean("", ResultBean.OK, "success");
        }catch (Exception e) {
            log.error("addUser: "+e.getMessage() + "_" + ExceptionUtils.getStackTrace(e));
            ExceptionErrorMessage message = getExceptionErrorMessage(e);
            return new ResultBean(null, message.getErrCode(),message.getErrMsg());
        }
    }

}
