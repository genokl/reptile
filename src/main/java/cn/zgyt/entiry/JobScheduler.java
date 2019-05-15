package cn.zgyt.entiry;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class JobScheduler {

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
	
	private String listSele;
	private String infoSele;
	private String keywordSele;
	private String titleSele;
	private String dateSele;
	
	//触发器名
    private String trigget;
    //触发器组名
    private String triggetGroup;
    private String baseUrl;
    private String filterStr;
    private String filterTag;
    private String articleType;
    private String dateFormateStr;
    
    
    
	
	public String getTitleSele() {
		return titleSele;
	}
	public void setTitleSele(String titleSele) {
		this.titleSele = titleSele;
	}
	public String getDateSele() {
		return dateSele;
	}
	public void setDateSele(String dateSele) {
		this.dateSele = dateSele;
	}
	public String getKeywordSele() {
		return keywordSele;
	}
	public void setKeywordSele(String keywordSele) {
		this.keywordSele = keywordSele;
	}
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
	public String getListSele() {
		return listSele;
	}
	public void setListSele(String listSele) {
		this.listSele = listSele;
	}
	public String getInfoSele() {
		return infoSele;
	}
	public void setInfoSele(String infoSele) {
		this.infoSele = infoSele;
	}
	public void setTriggetGroup(String triggetGroup) {
		this.triggetGroup = triggetGroup;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public String getFilterStr() {
		return filterStr;
	}
	public void setFilterStr(String filterStr) {
		this.filterStr = filterStr;
	}
	public String getArticleType() {
		return articleType;
	}
	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}
	public String getFilterTag() {
		return filterTag;
	}
	public void setFilterTag(String filterTag) {
		this.filterTag = filterTag;
	}
	public String getDateFormateStr() {
		return dateFormateStr;
	}
	public void setDateFormateStr(String dateFormateStr) {
		this.dateFormateStr = dateFormateStr;
	}
	
	
}
