package cn.zgyt.crawler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class CsdnBlogProcessor implements PageProcessor {
 
    private static String username = "yixiao1874";// 设置csdn用户名
    private static int size = 0;// 共抓取到的文章数量
 
    // 抓取网站的相关配置，包括：编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    
    public static void main(String[] args) {
    	String url = "http://www.bjzgyt.cn/artD/page/5.html";
    	try {
    		WebClient wc = new WebClient(BrowserVersion.CHROME);
    		WebClientOptions options = wc.getOptions();
            options.setJavaScriptEnabled(true);              // 启用JS解释器，默认为true
            options.setCssEnabled(false);                    // 禁用css支持
            options.setThrowExceptionOnScriptError(false);   // js运行错误时，是否抛出异常
            options.setThrowExceptionOnFailingStatusCode(false);
            options.setTimeout(10 * 1000);                   // 设置连接超时时间
            HtmlPage page = wc.getPage(url);
            wc.waitForBackgroundJavaScript(30 * 1000);               // 等待js后台执行30秒
            String pageAsXml = page.asXml();
            // Jsoup解析处理
            Document doc = Jsoup.parse(pageAsXml, "http://www.bjzgyt.cn");  
            Elements pngs = doc.select("img[src$=.jpg]");
            System.out.println(pngs);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    @Override
    public void process(Page page) {
    	System.out.println(page);
    	System.out.println(page.getJson());
    	String string = page.getJson().jsonPath("$.name").get();
    }

	 @Override
	 public Site getSite() {
        return site;
    }
}
