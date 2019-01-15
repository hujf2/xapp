package tk.mybatis.springboot.model;

/**
 * @author junfeng.hu
 * @create 2018-12-10 18:14
 */

public class GroupEntry {
    private Integer countstatus;
    private Integer jobstatus;

    public Integer getCountstatus() {
        return countstatus;
    }

    public void setCountstatus(Integer countstatus) {
        this.countstatus = countstatus;
    }

    public Integer getJobstatus() {
        return jobstatus;
    }

    public void setJobstatus(Integer jobstatus) {
        this.jobstatus = jobstatus;
    }
}
