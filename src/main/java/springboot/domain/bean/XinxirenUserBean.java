package springboot.domain.bean;

import springboot.domain.XinxirenUser;

/**
 * Created by zhangshengchen on 2017/10/17.
 */
public class XinxirenUserBean extends XinxirenUser{

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
