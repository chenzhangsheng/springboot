package springboot.bean;

import springboot.domain.Role;
import springboot.domain.XinxirenUser;

/**
 * Created by zhangshengchen on 2017/10/17.
 */
public class XinxirenUserBean extends XinxirenUser{

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
