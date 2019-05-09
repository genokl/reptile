package cn.zgyt.crawler;
import java.util.List;

import cn.zgyt.utils.CommonUtil;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class CsdnBlogProcessor implements PageProcessor {
 
    private static String username = "yixiao1874";// 设置csdn用户名
    private static int size = 0;// 共抓取到的文章数量
 
    // 抓取网站的相关配置，包括：编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    
    public static void main(String[] args) {
        // 从用户博客首页开始抓，开启5个线程，启动爬虫
        Spider.create(new CsdnBlogProcessor())
        .addUrl("http://blog.csdn.net/" + username)
        .thread(5)
        .run();
        System.out.println("文章总数为"+size);
    }
    
    @Override
    public void process(Page page) {
    	//https://blog.csdn.net/yixiao1874/article/details/79496825
        if (!page.getUrl().regex("http://blog.csdn.net/" + username + "/article/details/\\d+").match()) {
            //获取当前页码
            String number = page.getHtml().xpath("//div[@class='pagination-box']").toString();
            //匹配当前页码+1的页码也就是下一页，加入爬取列表中
            if(CommonUtil.checkFull(number)) {
            	number="1";
            }
            String targetUrls = page.getHtml().links()
                    .regex("http://blog.csdn.net/"+username+"/article/list/"+(Integer.parseInt(number)+1)).get();
            page.addTargetRequest(targetUrls);
 
            List<String> detailUrls = page.getHtml().xpath("//li[@class='blog-unit']//a/@href").all();
            for(String list :detailUrls){
                System.out.println(list);
            }
            page.addTargetRequests(detailUrls);
        }else {
            size++;// 文章数量加1
            CsdnBlog csdnBlog = new CsdnBlog();
            String path = page.getUrl().get();
            int id = Integer.parseInt(path.substring(path.lastIndexOf("/")+1));
            String title = page.getHtml().xpath("//h1[@class='csdn_top']/text()").get();
            String date = page.getHtml().xpath("//div[@class='artical_tag']//span[@class='time']/text()").get();
            String copyright = page.getHtml().xpath("//div[@class='artical_tag']//span[@class='original']/text()").get();
            int view = Integer.parseInt(page.getHtml().xpath("//button[@class='btn-noborder']//span[@class='txt']/text()").get());
            csdnBlog.id(id).title(title).date(date).copyright(copyright).view(view);
            System.out.println(csdnBlog);
        }
    }

	 @Override
	 public Site getSite() {
        return site;
    }
}
