package tk.mybatis.springboot.model;

import javax.persistence.*;

public class RJobMessageentry {
	
    private Integer idJob;

    private String name;

    private String link;

    private Integer msgTypeid;

    private String managerAccount;

    public Integer getIdJob() {
        return idJob;
    }

    public void setIdJob(Integer idJob) {
        this.idJob = idJob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public Integer getMsgTypeid() {
        return msgTypeid;
    }

    public void setMsgTypeid(Integer msgTypeid) {
        this.msgTypeid = msgTypeid;
    }

    public String getManagerAccount() {
        return managerAccount;
    }

    public void setManagerAccount(String managerAccount) {
        this.managerAccount = managerAccount == null ? null : managerAccount.trim();
    }
}