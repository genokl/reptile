//package cn.zgyt.crawler;
//
//import cn.zgyt.entiry.TBookInfo;
//import us.codecraft.webmagic.Spider;
//
//public class WebMagicCrawler {
//	
//	public static void main(String[] args) {
//		TBookInfo tb = new TBookInfo();
//		tb.setId(101);
//        Spider.create(new DDNovelProcessor(tb,"https://www.dingdiann.com/ddk75013/"))
//                //从"第一章开始抓取"开始抓
//                .addUrl("https://www.dingdiann.com/ddk75013/")
//                .addPipeline(new BookDetailsMapperPipeline())//数据持久化
//                //开启5个线程抓取
//                .thread(10)
//                //启动爬虫
//                .run();
//    }
//
//}
