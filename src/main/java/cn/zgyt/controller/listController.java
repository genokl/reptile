package cn.zgyt.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zgyt.processer.service.AoyugeStoryAnalysisService;

@Controller
@RequestMapping("/listen")
public class listController {
	
	@Autowired
	private AoyugeStoryAnalysisService aoyugeStoryAnalysisService;
	
	@GetMapping("finddata")
	public void findData() {
		try {
//			StoryThread st=new StoryThread();
//			st.start();
			// 查询更新时间在一天之内的（不需要同步的项目）
//			aoyugeStoryService.analysisPageForTotal("http://www.aoyuge.com/fenlei-3-1.html", "http://www.aoyuge.com","", "都市言情");
//			aoyugeStoryAnalysisService.analysisPageForTotal("https://www.ysts8.com/Yshtml/Ys25367.html", "https://www.ysts8.com","", "都市言情");
			Document d = Jsoup.connect("https://www.baidu.com/s?wd=hrh").get();
			System.out.println(321321321);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
