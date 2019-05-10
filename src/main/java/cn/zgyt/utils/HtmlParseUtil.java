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
	public static List<String> analysisPage(String listPage,String baseUrl,String select,String aTipSelect) throws Exception{
		ArrayList<String> ll = new ArrayList<>();
	    Document doc = Jsoup.parse(listPage,baseUrl);  
        Elements divs = doc.select(select);//"div[class$='news-item']"
        for (int i = 0; i < divs.size(); i++) {
			Element e = divs.get(i);
			Elements aTip = e.select(aTipSelect);
			System.out.println(111);
		}
		return ll;
	}
}
