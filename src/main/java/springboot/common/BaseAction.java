package springboot.common;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import springboot.common.exception.InvalidRequestRuntimeException;
import springboot.common.exception.PlatformRequestRuntimeException;
import springboot.common.exception.PlatformRuntimeException;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by ChenZhangsheng on 2017/10/17.
 */
public class BaseAction {
    protected Logger log = Logger.getLogger(this.getClass());
    public static final String DEFAULT_CHARSET = "UTF-8";

    public void sendJsonMsg(String msg,HttpServletResponse response){
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter out = response.getWriter();
            out.write(msg);
            out.flush();
            out.close();
        } catch (Exception e) {
            log.error("send json error", e);
        }
    }
    public ExceptionErrorMessage getExceptionErrorMessage(Exception ex) {
        int errCode = -1;
        HttpStatus httpStatus = HttpStatus.OK;
        String mString = "";
        if (ex instanceof InvalidRequestRuntimeException) {
            InvalidRequestRuntimeException exception = (InvalidRequestRuntimeException)ex;
            errCode = exception.getErr();
            mString =  exception.getMessage();
        } else if (ex instanceof PlatformRequestRuntimeException) {
            PlatformRequestRuntimeException exception = (PlatformRequestRuntimeException)ex;
            errCode = exception.getErr();
            mString =  exception.getMessage();
        }else{
            errCode = 500;
            mString =  ex.getMessage();
        }

        return new ExceptionErrorMessage(errCode, httpStatus, mString);
    }


    /**
     *  异常信息实体
     * @author chaogao
     */
    public class ExceptionErrorMessage {
        private int errCode = -1;
        private HttpStatus httpStatus = HttpStatus.OK;
        private String errMsg = "";

        public ExceptionErrorMessage(int errCode, HttpStatus httpStatus, String errMsg) {
            super();
            this.errCode = errCode;
            this.httpStatus = httpStatus;
            this.errMsg = errMsg;
        }
        public int getErrCode() {
            return errCode;
        }
        public void setErrCode(int errCode) {
            this.errCode = errCode;
        }
        public HttpStatus getHttpStatus() {
            return httpStatus;
        }
        public void setHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
        }

        public String getErrMsg() {
            return errMsg;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }


    }

}
