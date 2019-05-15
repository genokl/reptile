package cn.zgyt.processer.aoyugeStory.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="new")
public class New {
	 
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
	private Integer id;
	/**
	 * 新闻名称
	 */
	private String newTitle;
	/**
	 * 新闻名称
	 */
	private String newInfo;
	private String filterUrl;
	private String keywords;
	
	private Date writeDate;
	private Date createDate;
	private String newType;
	private String newAuthor;

	
	
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNewTitle() {
		return newTitle;
	}
	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}
	public String getNewInfo() {
		return newInfo;
	}

	public void setNewInfo(String newInfo) {
		this.newInfo = newInfo;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getFilterUrl() {
		return filterUrl;
	}
	public void setFilterUrl(String filterUrl) {
		this.filterUrl = filterUrl;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	
	
	public String getNewType() {
		return newType;
	}
	public void setNewType(String newType) {
		this.newType = newType;
	}
	
	public String getNewAuthor() {
		return newAuthor;
	}
	public void setNewAuthor(String newAuthor) {
		this.newAuthor = newAuthor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((newTitle == null) ? 0 : newTitle.hashCode());
		result = prime * result + ((writeDate == null) ? 0 : writeDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		New other = (New) obj;
		if (newTitle == null) {
			if (other.newTitle != null)
				return false;
		} else if (!newTitle.equals(other.newTitle))
			return false;
		if (writeDate == null) {
			if (other.writeDate != null)
				return false;
		} else if (!sdf.format(writeDate).equals(sdf.format(other.writeDate)))
			return false;
		return true;
	}
	
	
	
}
