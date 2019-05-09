package cn.zgyt.entiry;

import java.io.Serializable;
import java.util.Date;

public class TBookInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1134298309123124362L;
	
	private Integer id;
	private String bookName;
	private String bookAuthor;
	private Integer bookTotalFields;
	private String lastFieldName;
	private Date lastUpdateTime;
	private Date updateTime;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public Integer getBookTotalFields() {
		return bookTotalFields;
	}
	public void setBookTotalFields(Integer bookTotalFields) {
		this.bookTotalFields = bookTotalFields;
	}
	public String getLastFieldName() {
		return lastFieldName;
	}
	public void setLastFieldName(String lastFieldName) {
		this.lastFieldName = lastFieldName;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	

}
