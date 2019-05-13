package cn.zgyt.processer.aoyugeStory.vo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
@Entity
@Table(name="story_chapter")
public class StoryChapter {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
	private Integer id;
	
	@ManyToOne(targetEntity=Story.class, fetch=FetchType.LAZY)
	private Story story;
	/**
	 * 章节名称
	 */
	private String chapterTitle;
	/**
	 * 章节排名
	 *  第一章第二章
	 */
	private String chapterSequence;
	/**
	 * 章节链接
	 */
	private String chapterUrl;
	/**
	 * 章节链接
	 */
	@Type(type="text") 
	private String chapterInfo;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChapterTitle() {
		return chapterTitle;
	}

	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}

	public String getChapterUrl() {
		return chapterUrl;
	}

	public void setChapterUrl(String chapterUrl) {
		this.chapterUrl = chapterUrl;
	}

	public String getChapterSequence() {
		return chapterSequence;
	}

	public void setChapterSequence(String chapterSequence) {
		this.chapterSequence = chapterSequence;
	}

	public String getChapterInfo() {
		return chapterInfo;
	}

	public void setChapterInfo(String chapterInfo) {
		this.chapterInfo = chapterInfo;
	}
	
	
	
}
