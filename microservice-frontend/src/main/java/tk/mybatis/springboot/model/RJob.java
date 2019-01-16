package tk.mybatis.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "R_JOB")
public class RJob extends BaseEntity{
	@Id
	@Column(name = "ID_JOB")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJob;

    private Integer idDirectory;

    private String name;

    private String jobVersion;

    private Integer jobStatus;

    private Integer idDatabaseLog;

    private String tableNameLog;

    private String createdUser;

    private Date createdDate;

    private String modifiedUser;

    private Date modifiedDate;

    private Boolean useBatchId;

    private Boolean passBatchId;

    private Boolean useLogfield;

    private String sharedFile;

    public Long getIdJob() {
        return idJob;
    }

    public void setIdJob(Long idJob) {
        this.idJob = idJob;
    }

    public Integer getIdDirectory() {
        return idDirectory;
    }

    public void setIdDirectory(Integer idDirectory) {
        this.idDirectory = idDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getJobVersion() {
        return jobVersion;
    }

    public void setJobVersion(String jobVersion) {
        this.jobVersion = jobVersion == null ? null : jobVersion.trim();
    }

    public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Integer getIdDatabaseLog() {
        return idDatabaseLog;
    }

    public void setIdDatabaseLog(Integer idDatabaseLog) {
        this.idDatabaseLog = idDatabaseLog;
    }

    public String getTableNameLog() {
        return tableNameLog;
    }

    public void setTableNameLog(String tableNameLog) {
        this.tableNameLog = tableNameLog == null ? null : tableNameLog.trim();
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser == null ? null : createdUser.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser == null ? null : modifiedUser.trim();
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Boolean getUseBatchId() {
        return useBatchId;
    }

    public void setUseBatchId(Boolean useBatchId) {
        this.useBatchId = useBatchId;
    }

    public Boolean getPassBatchId() {
        return passBatchId;
    }

    public void setPassBatchId(Boolean passBatchId) {
        this.passBatchId = passBatchId;
    }

    public Boolean getUseLogfield() {
        return useLogfield;
    }

    public void setUseLogfield(Boolean useLogfield) {
        this.useLogfield = useLogfield;
    }

    public String getSharedFile() {
        return sharedFile;
    }

    public void setSharedFile(String sharedFile) {
        this.sharedFile = sharedFile == null ? null : sharedFile.trim();
    }
}