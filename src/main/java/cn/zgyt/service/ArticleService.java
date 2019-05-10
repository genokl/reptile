package cn.zgyt.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleService {

	
	//增加自定义表指定数据
		@Transactional(rollbackFor = Exception.class )
		public String analysisPage(String str) throws Exception{
		    Document doc = Jsoup.parse(str, "http://www.bjzgyt.cn");  
            Elements divs = doc.select("div[class$='news-item']");
            for (int i = 0; i < divs.size(); i++) {
				Element e = divs.get(i);
				System.out.println(e);
			}
			System.out.println(str);//articleList
			System.out.println(str);
			System.out.println(str);
			return str;
		}
	
}
