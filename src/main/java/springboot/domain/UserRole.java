package springboot.domain;

import springboot.common.BaseDO;

import javax.persistence.Table;

/**
 * Created by ChenZhangsheng on 2017/10/16.
 */
@Table(name ="user_role")
public class UserRole extends BaseDO {
    private Long uid;
    private Long rid;
    private String note;
    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    public Long getRid() {
        return rid;
    }
    public void setRid(Long rid) {
        this.rid = rid;
    }
    public String getNote() {return note;}
    public void setNote(String note) {this.note = note;}

}
