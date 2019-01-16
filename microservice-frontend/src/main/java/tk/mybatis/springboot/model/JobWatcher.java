package tk.mybatis.springboot.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "JOB_WATCHER")
public class JobWatcher extends BaseEntity{

    @Column(name = "ID_JOB")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id private Integer idJob;

    private Integer status;

    private Integer timeSecond;

    private Integer dataAmount;

    private Long createdTime;

    private Double percentage;

    public JobWatcher() {
    }

    public JobWatcher(Integer idJob, Integer status) {
        this.idJob = idJob;
        this.status = status;
    }

    public Integer getIdJob() {
        return idJob;
    }

    public void setIdJob(Integer idJob) {
        this.idJob = idJob;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTimeSecond() {
        return timeSecond;
    }

    public void setTimeSecond(Integer timeSecond) {
        this.timeSecond = timeSecond;
    }

    public Integer getDataAmount() {
        return dataAmount;
    }

    public void setDataAmount(Integer dataAmount) {
        this.dataAmount = dataAmount;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
}