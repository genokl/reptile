package cn.zgyt.utils;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class reptileUtil {

	/**
	 * 
	 * @param browserVersion 浏览器版本 
	 * @param url	请求url
	 * @return
	 * @throws Exception
	 */
	public static String getPage(BrowserVersion browserVersion,String url) throws Exception {
		//BrowserVersion.CHROME
		WebClient wc = new WebClient(browserVersion);
		WebClientOptions options = wc.getOptions();
        options.setJavaScriptEnabled(true);              // 启用JS解释器，默认为true
        options.setCssEnabled(false);                    // 禁用css支持
        options.setThrowExceptionOnScriptError(false);   // js运行错误时，是否抛出异常
        options.setThrowExceptionOnFailingStatusCode(false);
        options.setTimeout(10 * 1000);                   // 设置连接超时时间
        HtmlPage page = wc.getPage(url);
        wc.waitForBackgroundJavaScript(30 * 1000);               // 等待js后台执行30秒
        String pageAsXml = page.asXml();
        return pageAsXml;
	}
}
