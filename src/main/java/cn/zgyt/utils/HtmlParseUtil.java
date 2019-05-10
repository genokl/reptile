package cn.zgyt.utils;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParseUtil {

	/**
	 * 分析列表页面，列表元素连接
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public List<String> analysisPage(String listPage,String baseUrl) throws Exception{
		ArrayList<String> ll = new ArrayList<>();
	    Document doc = Jsoup.parse(listPage,baseUrl);  
        Elements divs = doc.select("div[class$='news-item']");
        for (int i = 0; i < divs.size(); i++) {
			Element e = divs.get(i);
			System.out.println(e);
		}
		return ll;
	}
}
