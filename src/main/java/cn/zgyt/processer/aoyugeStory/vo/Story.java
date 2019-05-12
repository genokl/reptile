package cn.zgyt.processer.aoyugeStory.vo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="story")
public class Story {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
	private Integer id;
	/**
	 * 小说名称
	 */
	private String storyTitle;
	/**
	 * 小说作者
	 */
	private String storyAuther;
	/**
	 * 小说简介
	 */
	private String storySynopsis;
	/**
	 * 小说类型
	 */
	private String storyType;
	/**
	 * 小说状态
	 */
	private String storyStatus;
	/**
	 * 小说封面图片
	 */
	private String storyPic;
	/**
	 * 小说封面图片
	 */
	private String storyFirstPage;
	/**
	 * 小说封面图片
	 */
	private String filterUrl;
	/**
	 * 小说封面图片
	 */
	private String baseUrl;
	
	@Transient
	private List<StoryChapter> chapter;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStoryTitle() {
		return storyTitle;
	}
	public void setStoryTitle(String storyTitle) {
		this.storyTitle = storyTitle;
	}
	public String getStoryAuther() {
		return storyAuther;
	}
	public void setStoryAuther(String storyAuther) {
		this.storyAuther = storyAuther;
	}
	public String getStorySynopsis() {
		return storySynopsis;
	}
	public void setStorySynopsis(String storySynopsis) {
		this.storySynopsis = storySynopsis;
	}
	public String getStoryType() {
		return storyType;
	}
	public void setStoryType(String storyType) {
		this.storyType = storyType;
	}
	public String getStoryStatus() {
		return storyStatus;
	}
	public void setStoryStatus(String storyStatus) {
		this.storyStatus = storyStatus;
	}
	public String getStoryPic() {
		return storyPic;
	}
	public void setStoryPic(String storyPic) {
		this.storyPic = storyPic;
	}
	public String getStoryFirstPage() {
		return storyFirstPage;
	}
	public void setStoryFirstPage(String storyFirstPage) {
		this.storyFirstPage = storyFirstPage;
	}
	public String getFilterUrl() {
		return filterUrl;
	}
	public void setFilterUrl(String filterUrl) {
		this.filterUrl = filterUrl;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public List<StoryChapter> getChapter() {
		return chapter;
	}
	public void setChapter(List<StoryChapter> chapter) {
		this.chapter = chapter;
	}
	
	
	
	
	
	
	
	
	
}
