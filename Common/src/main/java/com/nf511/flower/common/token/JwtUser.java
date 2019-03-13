package com.nf511.flower.common.token;

import java.io.Serializable;


public class JwtUser implements Serializable {
    private static final long serialVersionUID = 8715844912534284943L;
    private String id;
    private String uname;
    private Long loginTime;//登录时间

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public Long getLoginTime() {
        return loginTime;
    }
    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

}
