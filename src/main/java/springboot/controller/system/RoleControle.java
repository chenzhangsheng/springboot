package springboot.controller.system;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.common.ActionURLContstants;
import springboot.common.BaseAction;
import springboot.common.ErrConstatns;
import springboot.common.ResultBean;
import springboot.common.exception.PlatformRequestRuntimeException;
import springboot.common.query.RoleQuery;
import springboot.common.query.XinxirenUserQuery;
import springboot.common.utils.HttpRequestUtil;
import springboot.common.utils.StringUtils;
import springboot.domain.Permission;
import springboot.domain.Role;
import springboot.service.RoleManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zhangshengchen on 2017/10/19.
 */
@Controller
public class RoleControle extends BaseAction{

    @Autowired
    private RoleManager roleManager;

    @RequestMapping(value = ActionURLContstants.PRIVATE + "/" + ActionURLContstants.VERSION_V1+"/addRole", method = { RequestMethod.POST })
    @ResponseBody
    public Object addRole(HttpServletRequest request, HttpServletResponse response){
        try{
            RoleQuery roleQuery = HttpRequestUtil.getRequestQuerryBean(request,RoleQuery.class);
            if(StringUtils.isEmpty(roleQuery.getName())){
                throw new PlatformRequestRuntimeException(ErrConstatns.getCodeMessage(ErrConstatns.API3_PARAMETER_ERROR), ErrConstatns.API3_PARAMETER_ERROR, HttpStatus.OK);
            }
            roleManager.addRole(roleQuery);
            return new ResultBean("", ResultBean.OK, "success");
        }catch (Exception e) {
            log.error("addUser: "+e.getMessage() + "_" + ExceptionUtils.getStackTrace(e));
            BaseAction.ExceptionErrorMessage message = getExceptionErrorMessage(e);
            return new ResultBean(null, message.getErrCode(),message.getErrMsg());
        }
    }

    @RequestMapping(value = ActionURLContstants.PRIVATE + "/" + ActionURLContstants.VERSION_V1+"/GetRoleList", method = { RequestMethod.POST ,RequestMethod.GET})
    @ResponseBody
    public Object GetPermission(HttpServletRequest request, HttpServletResponse response){
        try{
            RoleQuery roleQuery = HttpRequestUtil.getRequestQuerryBean(request,RoleQuery.class);
            List<Role> list = roleManager.GetRoleList(roleQuery);
            return new ResultBean(list, ResultBean.OK, "success");
        }catch (Exception e) {
            log.error("addUser: "+e.getMessage() + "_" + ExceptionUtils.getStackTrace(e));
            BaseAction.ExceptionErrorMessage message = getExceptionErrorMessage(e);
            return new ResultBean(null, message.getErrCode(),message.getErrMsg());
        }
    }

    @RequestMapping(value = ActionURLContstants.PRIVATE + "/" + ActionURLContstants.VERSION_V1+"/updateRole", method = { RequestMethod.POST })
    @ResponseBody
    public Object updateRole(HttpServletRequest request, HttpServletResponse response){
        try{
            RoleQuery roleQuery = HttpRequestUtil.getRequestQuerryBean(request,RoleQuery.class);
            if(roleQuery.getId() == null ){
                throw new PlatformRequestRuntimeException(ErrConstatns.getCodeMessage(ErrConstatns.API3_PARAMETER_ERROR), ErrConstatns.API3_PARAMETER_ERROR, HttpStatus.OK);
            }
            roleManager.updateRole(roleQuery);
            return new ResultBean("", ResultBean.OK, "success");
        }catch (Exception e) {
            log.error("addUser: "+e.getMessage() + "_" + ExceptionUtils.getStackTrace(e));
            BaseAction.ExceptionErrorMessage message = getExceptionErrorMessage(e);
            return new ResultBean(null, message.getErrCode(),message.getErrMsg());
        }
    }
    @RequestMapping(value = ActionURLContstants.PRIVATE + "/" + ActionURLContstants.VERSION_V1+"/deleteRole", method = { RequestMethod.POST })
    @ResponseBody
    public Object deleteRole(HttpServletRequest request, HttpServletResponse response){
        try{
            RoleQuery roleQuery = HttpRequestUtil.getRequestQuerryBean(request,RoleQuery.class);
            if(roleQuery.getId() == null ){
                throw new PlatformRequestRuntimeException(ErrConstatns.getCodeMessage(ErrConstatns.API3_PARAMETER_ERROR), ErrConstatns.API3_PARAMETER_ERROR, HttpStatus.OK);
            }
            roleManager.deleteRole(roleQuery.getId());
            return new ResultBean("", ResultBean.OK, "success");
        }catch (Exception e) {
            log.error("addUser: "+e.getMessage() + "_" + ExceptionUtils.getStackTrace(e));
            BaseAction.ExceptionErrorMessage message = getExceptionErrorMessage(e);
            return new ResultBean(null, message.getErrCode(),message.getErrMsg());
        }
    }
}
