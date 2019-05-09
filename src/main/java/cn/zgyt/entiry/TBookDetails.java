package cn.zgyt.entiry;

import java.io.Serializable;
import java.util.Date;

public class TBookDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4123105669787725052L;
	
	private Long id;
	private Integer bookId;
	private String bookTitle;
	private String bookContent;
	private Date updateTime;
	private Date createTime;
	private Integer bookFieldSort;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookContent() {
		return bookContent;
	}
	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
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
	public Integer getBookFieldSort() {
		return bookFieldSort;
	}
	public void setBookFieldSort(Integer bookFieldSort) {
		this.bookFieldSort = bookFieldSort;
	}
	

}
