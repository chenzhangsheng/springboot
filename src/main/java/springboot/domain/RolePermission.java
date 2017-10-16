package springboot.domain;

import springboot.common.BaseDO;

import javax.persistence.Table;

/**
 * Created by ChenZhangsheng on 2017/10/16.
 */
@Table(name ="role_permission")
public class RolePermission extends BaseDO {

    private Long rid;//角色id
    private Long pid;//权限id
    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }



}
