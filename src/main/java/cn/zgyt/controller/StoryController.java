package cn.zgyt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zgyt.processer.service.AoyugeStoryAnalysisService;
import cn.zgyt.processer.thread.StoryThread;

@Controller
@RequestMapping("/story")
public class StoryController {
	
	@Autowired
	private AoyugeStoryAnalysisService aoyugeStoryAnalysisService;
	
	@GetMapping("finddata")
	public void findData() {
		try {
//			StoryThread st=new StoryThread();
//			st.start();
			// 查询更新时间在一天之内的（不需要同步的项目）
//			aoyugeStoryService.analysisPageForTotal("http://www.aoyuge.com/fenlei-3-1.html", "http://www.aoyuge.com","", "都市言情");
			aoyugeStoryAnalysisService.analysisPageForTotal("http://www.aoyuge.com/fenlei-3-1.html", "http://www.aoyuge.com","", "都市言情");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
