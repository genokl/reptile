package cn.zgyt.service;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import cn.zgyt.utils.HtmlParseUtil;
import cn.zgyt.utils.reptileUtil;

@Service
public class ArticleService {

	
	//增加自定义表指定数据
		@Transactional(rollbackFor = Exception.class )
		public String analysisPage(String url,String baseUrl,String selectStr) throws Exception{
			String page = reptileUtil.getPage(BrowserVersion.CHROME,url);
			List<String> urlList = HtmlParseUtil.analysisPage(page, baseUrl, selectStr,null);//"div[class$='note']"
			System.out.println("3131");
			return page;
		}
	
}
