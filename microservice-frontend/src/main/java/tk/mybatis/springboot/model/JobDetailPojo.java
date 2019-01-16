package tk.mybatis.springboot.model;

import java.util.Map;

/**
 * @author junfeng.hu
 * @create 2018-10-16 15:02
 */
public class JobDetailPojo {
    private Long idJob;
    private String jobName;
    private Integer status;
    private String msg;
    private Double intervalSeconds;
    private Double intervalMinutes;
    private Double hour;
    private Integer schedulerType;
    private String name;
    private String serverName;
    private Integer serverId;
    private Integer portId;

    private String pluginName;
    private Integer pluginId;

    private String rootNode;
    private String preNode;
    private String node;
    private Integer rootNodeVal;
    private Integer preNodeVal;
    private Integer nodeVal;

    Map<Object,Object> cacheMap;

    private Integer timeSecond;
    private Integer dataAmount;
    private Double percentage;
    private Integer watchStatus;

    private Integer redpoint;
    private String createdTime;

    private String messageChannelName;
    private Integer messageChannelId;

    public Integer getWatchStatus() {
        return watchStatus;
    }

    public void setWatchStatus(Integer watchStatus) {
        this.watchStatus = watchStatus;
    }

    public String getMessageChannelName() {
        return messageChannelName;
    }

    public void setMessageChannelName(String messageChannelName) {
        this.messageChannelName = messageChannelName;
    }

    public Integer getMessageChannelId() {
        return messageChannelId;
    }

    public void setMessageChannelId(Integer messageChannelId) {
        this.messageChannelId = messageChannelId;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getRedpoint() {
        return redpoint;
    }

    public void setRedpoint(Integer redpoint) {
        this.redpoint = redpoint;
    }

    public Integer getPortId() {
        return portId;
    }

    public void setPortId(Integer portId) {
        this.portId = portId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
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

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Map<Object, Object> getCacheMap() {
        return cacheMap;
    }

    public void setCacheMap(Map<Object, Object> cacheMap) {
        this.cacheMap = cacheMap;
    }

    public String getRootNode() {
        return rootNode;
    }

    public void setRootNode(String rootNode) {
        this.rootNode = rootNode;
    }

    public String getPreNode() {
        return preNode;
    }

    public void setPreNode(String preNode) {
        this.preNode = preNode;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public Integer getRootNodeVal() {
        return rootNodeVal;
    }

    public void setRootNodeVal(Integer rootNodeVal) {
        this.rootNodeVal = rootNodeVal;
    }

    public Integer getPreNodeVal() {
        return preNodeVal;
    }

    public void setPreNodeVal(Integer preNodeVal) {
        this.preNodeVal = preNodeVal;
    }

    public Integer getNodeVal() {
        return nodeVal;
    }

    public void setNodeVal(Integer nodeVal) {
        this.nodeVal = nodeVal;
    }

    public JobDetailPojo() {
    }


    public Integer getStatus() {
        return status;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public Integer getPluginId() {
        return pluginId;
    }

    public void setPluginId(Integer pluginId) {
        this.pluginId = pluginId;
    }

    public Long getIdJob() {
        return idJob;
    }

    public void setIdJob(Long idJob) {
        this.idJob = idJob;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getIntervalSeconds() {
        return intervalSeconds;
    }

    public void setIntervalSeconds(Double intervalSeconds) {
        this.intervalSeconds = intervalSeconds;
    }

    public Double getIntervalMinutes() {
        return intervalMinutes;
    }

    public void setIntervalMinutes(Double intervalMinutes) {
        this.intervalMinutes = intervalMinutes;
    }

    public Double getHour() {
        return hour;
    }

    public void setHour(Double hour) {
        this.hour = hour;
    }

    public Integer getSchedulerType() {
        return schedulerType;
    }

    public void setSchedulerType(Integer schedulerType) {
        this.schedulerType = schedulerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public JobDetailPojo(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }


    public JobDetailPojo(Integer status,  String jobName, Long idJob) {
        this.status = status;
        this.jobName = jobName;
        this.idJob = idJob;
    }

    @Override
    public String toString() {
        return "JobDetailPojo{" +
                "idJob=" + idJob +
                ", jobName='" + jobName + '\'' +
                ", status=" + status +
                ", msg='" + msg + '\'' +
                ", intervalSeconds=" + intervalSeconds +
                ", intervalMinutes=" + intervalMinutes +
                ", hour=" + hour +
                ", schedulerType=" + schedulerType +
                ", name='" + name + '\'' +
                ", serverName='" + serverName + '\'' +
                ", serverId=" + serverId +
                ", pluginName='" + pluginName + '\'' +
                ", pluginId=" + pluginId +
                ", rootNode='" + rootNode + '\'' +
                ", preNode='" + preNode + '\'' +
                ", node='" + node + '\'' +
                ", rootNodeVal=" + rootNodeVal +
                ", preNodeVal=" + preNodeVal +
                ", nodeVal=" + nodeVal +
                ", cacheMap=" + cacheMap +
                ", timeSecond=" + timeSecond +
                ", dataAmount=" + dataAmount +
                ", percentage=" + percentage +
                '}';
    }
}
