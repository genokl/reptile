package cn.zgyt.processer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import cn.zgyt.processer.aoyugeStory.vo.Story;
import cn.zgyt.processer.aoyugeStory.vo.StoryChapter;
import cn.zgyt.repo.StoryChapterRepository;
import cn.zgyt.repo.StoryRepository;
import cn.zgyt.utils.ConstantPool;

/**
 * 读取文章到缓存
 * 
 * @author epc-624
 */
@Service
public class AoyugeStoryAnalysisService {

	@Autowired
	private StoryChapterRepository scRep;
	@Autowired
	private StoryRepository sRep;

	/**
	  * 获取所有的页面链接
	  * @param url 某系列某类型小说
	  * @param baseUrl 某小说网站base
	  * @param filterUrl 某小说网站过滤字符串 
	  * @param storyType 小说类型
	  * @param startNum 小说列表开始页数
	  * @param endNum 小说列表完结页数
	  * @param 共爬取多少本小说
	 * @return
	 */
	public List<String> analysisPageForTotal(
			String url, 
			String baseUrl, 
			String filterUrl, 
			String storyType,
			Integer startNum,
			Integer endNum,
			Integer storyNum) {
		List<String> pageUrl = new ArrayList<String>();
		Map<String, Integer> mm = new HashMap<>();
		try {
			Document d = Jsoup.connect(url).get();
			Elements select = d.select(".pages .pagelink >a"); 
			for (int i = startNum-1; i < endNum; i++) {
				String targeturl = baseUrl+"/fenlei-3-" + (i + 1) + ".html";
				pageUrl.add(targeturl);
				analysisOnePageForTotal(targeturl, baseUrl, filterUrl, storyType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String analysisOnePageForTotal(String url, String baseUrl, String filterUrl, String storyType)
			throws Exception {

		List<String> pageUrl = new ArrayList<String>();

		Document d = Jsoup.connect(url).get();
		Elements item_conS = d.select(".item-con > li");
		for (Element e : item_conS) {
			Story story = new Story();
			Elements a = e.select(".s2 > a");
			story.setStoryTitle(a.text());
			String attr = a.attr("href");
			story.setStoryFirstPage(attr);
			story.setFilterUrl(filterUrl);
			story.setBaseUrl(baseUrl);
			analysisPageForOneStory(story);
		}
//		System.out.println(new Date());
		return null;
	}

	/**
	 * 获取该小说全部章节列表
	 * 
	 * @param ll
	 * @return
	 * @throws Exception
	 */
	@Async
	public List<String> analysisPageForOneStory(Story s) throws Exception {
//			for (int i = 0; i < ll.size(); i++) {
		List<StoryChapter> lls = new ArrayList<>();
//				Story s = ll.get(i);
		System.out.println("获取：" + s.getStoryTitle());
		String storyFirstPage = s.getStoryFirstPage();
		Document d = Jsoup.connect(storyFirstPage).get();
		Elements info = d.select(".info");
		String author = info.select(".btitle > i").text().split("：")[1];
		String text = info.select(".js").text().split("：")[1];
		Elements wode = info.select(".wode > strong");
		Elements chapters = d.select(".chapterlist > dd > a");
		s.setStoryAuther(author);
		s.setStorySynopsis(text);
		Story storyData = sRep.findByStoryAutherAndStoryTitle(s.getStoryAuther(), s.getStoryTitle());
		if (storyData == null) {
			Integer count = 1;
			for (Element chapter : chapters) {
				StoryChapter sc = new StoryChapter();
				String[] ss = chapter.text().split(" ");
				if (ss.length == 2) {
					sc.setChapterTitle(ss[1]);
				}
				sc.setChapterSequence(count + "");
				System.out.println(s.getStoryTitle()+"--"+chapter.text());
				count++;
				sc.setChapterUrl(s.getBaseUrl() + chapter.attr("href"));
				lls.add(sc);
				s.setChapter(lls);
			}

			for (Element es : wode) {
				String ss = es.text().split("：")[1];
				s.setStoryType(ss);
				break;
			}
			analysisPageForOneChapter(s);
		}
		return null;
	}

	public List<String> analysisPageForOneChapter(Story story) throws Exception {
		List<StoryChapter> scs = story.getChapter();
		for (int i = 0; i < scs.size(); i++) {
//				System.out.println(story.getStoryTitle()+"，共"+scs.size()+"章,当前"+i+"章");
			StoryChapter chapter = scs.get(i);
			Document d = Jsoup.connect(chapter.getChapterUrl()).get();
			String info = d.select("#BookText").text().replaceAll("&nbsp;", "");
			chapter.setChapterInfo(info);
		}
		ConstantPool.addToLl(story);
//			System.out.println("保存："+story.getStoryTitle());
		return null;
	}
	
	@Transactional
	public List<String> saveStory(Story story) throws Exception {
		List<StoryChapter> scs = story.getChapter();
		sRep.save(story);
		String storyId=story.getId()+"";
		for (int i = 0; i < scs.size(); i++) {
			scs.get(i).setStoryId(storyId);
		}
		scRep.save(scs);
		return null;
	}

}
