package springboot.controller.system;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.common.BaseAction;
import springboot.common.ResultBean;
import springboot.common.query.XinxirenUserQuery;
import springboot.common.utils.HttpRequestUtil;
import springboot.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ChenZhangsheng on 2017/10/17.
 */
@Controller
public class UserControle extends BaseAction{
    @Autowired
    private UserService userService;

    @RequestMapping(value ="/getUserList", method = { RequestMethod.POST ,RequestMethod.GET})
    @ResponseBody
    public Object webCdnAddForbidden(HttpServletRequest request, HttpServletResponse response){
        try{
            XinxirenUserQuery xinxirenUserQuery = HttpRequestUtil.getRequestQuerryBean(request,XinxirenUserQuery.class);
            return new ResultBean(userService.GetUserList(xinxirenUserQuery), ResultBean.OK, "success");
        }catch (Exception e) {
            log.error("getUserList: "+e.getMessage() + "_" + ExceptionUtils.getStackTrace(e));
            ExceptionErrorMessage message = getExceptionErrorMessage(e);
            return new ResultBean(null, message.getErrCode(),message.getErrMsg());
        }
    }
}