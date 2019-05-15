package cn.zgyt.processer.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zgyt.entiry.JobScheduler;
import cn.zgyt.processer.aoyugeStory.vo.New;
import cn.zgyt.repo.NewRepository;
import cn.zgyt.utils.CommonUtil;
import cn.zgyt.utils.ConstantPool;

/**
 * 读取文章到缓存
 * 
 * @author epc-624
 */
@Service
public class NewStoryAnalysisService {

	@Autowired
	private NewRepository newRep;

	/**
	  * 获取所有的页面链接
	 * @return
	 */
//	@Transactional(rollbackFor = Exception.class )
	public String analysisPageForList(JobScheduler js) {
		List<String> pageUrl = new ArrayList<String>();
		Map<String, Integer> mm = new HashMap<>();
		Map<String,String> m=new HashMap<>();
		try {
			Document d = Jsoup.connect(js.getCronExcuteUrl()).get();
			String listSele = js.getListSele();
			Elements list = d.select(listSele);
			for (Element e : list) {
				String attr = e.attr("href");
				pageUrl.add(attr);
				m.put(e.text(), attr);
			}
			analysisPageForInfo(js, m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional(rollbackFor = Exception.class )
	public String analysisPageForInfo(JobScheduler js,Map<String,String> m) {
		Set<Entry<String, String>> es = m.entrySet();
		for (Entry<String, String> e : es) {
			try {
				List<String> ll=ConstantPool.getNewsUrl();
				if(ll.size()==0||!ll.contains(e.getValue())) {
					New n = new New();
					Document d = Jsoup.connect(e.getValue()).get();
					String title = d.select(js.getTitleSele()).text();
					if(!CommonUtil.checkFull(js.getDateSele())) {
						String date = d.select(js.getDateSele()).text();
						n.setWriteDate(new SimpleDateFormat(js.getDateFormateStr()).parse(date));
					}
//				Elements ss = d.select(".article-content-left");
					if(!CommonUtil.checkFull(js.getDateSele())) {
						String keywords = d.select(js.getKeywordSele()).text();
						n.setKeywords(keywords);
					}
					Elements info = d.select(js.getInfoSele());
					if(!CommonUtil.checkFull(js.getDateSele())) {
						Elements show_author = info.select(js.getFilterTag()).remove();
					}
					n.setNewTitle(e.getKey());
					n.setCreateDate(new Date());
					n.setNewInfo(info.text());
					n.setNewType(js.getArticleType());
					ll.add(e.getValue());
					newRep.save(n);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}
	
}
