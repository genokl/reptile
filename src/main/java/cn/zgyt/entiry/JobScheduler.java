package cn.zgyt.entiry;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class JobScheduler {

	public static final String JOB_PARAM = "jobParam";
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String cronExpression;
	private String jobName;
	private String jobGroup;
	private String cronExcuteUrl;
	private Date createDate;
	private Date updateDate;
	private Integer isExcute;
	//触发器名
    private String trigget;
    //触发器组名
    private String triggetGroup;
    
    
    
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCronExpression() {
		return cronExpression;
	}
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getCronExcuteUrl() {
		return cronExcuteUrl;
	}
	public void setCronExcuteUrl(String cronExcuteUrl) {
		this.cronExcuteUrl = cronExcuteUrl;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getIsExcute() {
		return isExcute;
	}
	public void setIsExcute(Integer isExcute) {
		this.isExcute = isExcute;
	}
	public String getJobGroup() {
		return jobGroup;
	}
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	public String getTrigget() {
		return trigget;
	}
	public void setTrigget(String trigget) {
		this.trigget = trigget;
	}
	public String getTriggetGroup() {
		return triggetGroup;
	}
	
	
}
