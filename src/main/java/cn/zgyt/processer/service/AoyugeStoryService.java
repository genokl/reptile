package cn.zgyt.processer.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zgyt.processer.aoyugeStory.constantPool;
import cn.zgyt.processer.aoyugeStory.vo.Story;
import cn.zgyt.processer.aoyugeStory.vo.StoryChapter;
import cn.zgyt.processer.repo.StoryChapterRepository;
import cn.zgyt.processer.repo.StoryRepository;

@Service
public class AoyugeStoryService {

	@Autowired
	private StoryChapterRepository scRep;
	@Autowired
	private StoryRepository sRep;
	
	//增加自定义表指定数据
//		@Transactional(rollbackFor = Exception.class )
//		public String analysisPage(String url,String baseUrl,String selectStr) throws Exception{
//			String page = reptileUtil.getPage(BrowserVersion.CHROME,url);
//			List<String> urlList = HtmlParseUtil.analysisPage(page, baseUrl, selectStr,null);//"div[class$='note']"
//			System.out.println("3131");
//			return page;
//		}
	@Transactional(rollbackFor = Exception.class )
	public List<String> analysisPageForTotal(String url,String baseUrl,String filterUrl,String storyType) {
		List<String> pageUrl = new ArrayList<String>();
		Map<String, Integer> mm=new HashMap<>();
		try {
			Document d = Jsoup.connect(url).get();
			Elements select = d.select(".pages .pagelink >a");
			for (int i = 0; i < 177; i++) {
				String targeturl="http://www.aoyuge.com/fenlei-3-"+(i+1)+".html";
				pageUrl.add(targeturl);
				analysisOnePageForTotal(targeturl, baseUrl, filterUrl, storyType);
			}
//			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

		@Transactional(rollbackFor = Exception.class )
		public String analysisOnePageForTotal(String url,String baseUrl,String filterUrl,String storyType) throws Exception {
			
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
//					ll.add(story);
					constantPool.addToLl(story);
					analysisPageForOneStory(story);
				}
				System.out.println(new Date());
			return null;
		}

		/**
		 * 获取该小说全部章节列表
		 * @param ll
		 * @return
		 * @throws Exception
		 */
		@Transactional(rollbackFor = Exception.class)
		public List<String> analysisPageForOneStory(Story s) throws Exception {
//			for (int i = 0; i < ll.size(); i++) {
				List<StoryChapter> lls = new ArrayList<>();
//				Story s = ll.get(i);
				System.out.println("获取："+s.getStoryTitle());
				String storyFirstPage = s.getStoryFirstPage();
				Document d = Jsoup.connect(storyFirstPage).get();
				Elements info = d.select(".info");
				String author = info.select(".btitle > i").text().split("：")[1];
				String text = info.select(".js").text().split("：")[1];
				Elements wode = info.select(".wode > strong");
				Elements chapters = d.select(".chapterlist > dd > a");
				Integer count=1;
				for (Element chapter : chapters) {
					System.out.println(chapter);
					StoryChapter sc=new StoryChapter();
					String[] ss = chapter.text().split(" ");
					if(ss.length==2) {
						sc.setChapterTitle(ss[1]);
					}
					sc.setChapterSequence(count+"");
					count++;
					sc.setChapterUrl(s.getBaseUrl()+chapter.attr("href"));
					lls.add(sc);
					s.setChapter(lls);
				}
				
				for (Element es : wode) {
					String ss=es.text().split("：")[1];
					s.setStoryType(ss);
					break;
				}
				s.setStoryAuther(author);
				s.setStorySynopsis(text);
				analysisPageForOneChapter(s);
//			}
			return null;
		}

		@Transactional(rollbackFor = Exception.class )
		public List<String> analysisPageForOneChapter(Story story) throws IOException {
			List<StoryChapter> scs = story.getChapter();
			for (int i = 0; i < scs.size(); i++) {
				StoryChapter chapter = scs.get(i);
				Document d = Jsoup.connect(chapter.getChapterUrl()).get();
				String info = d.select("#BookText").text();
				chapter.setChapterInfo(info);
			}
			sRep.save(story);
			System.out.println(story);
			return null;
		}
	
}
