package cn.zgyt.entiry;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class JobDetail {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String cron;
	private String cronName;
	private String cronExcuteUrl;
	private Date createDate;
	private Date updateDate;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCron() {
		return cron;
	}
	public void setCron(String cron) {
		this.cron = cron;
	}
	public String getCronName() {
		return cronName;
	}
	public void setCronName(String cronName) {
		this.cronName = cronName;
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
	
	
}
