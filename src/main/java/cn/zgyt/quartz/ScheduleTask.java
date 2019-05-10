package cn.zgyt.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import cn.zgyt.service.ArticleService;
import cn.zgyt.utils.reptileUtil;  
  
@Configuration  
@Component // 此注解必加  
@EnableScheduling // 此注解必加  
public class ScheduleTask {  
	
    private static final Logger LOGGER =  LoggerFactory.getLogger(ScheduleTask.class);
    
    @Autowired
    private ArticleService articleService;
    /**
     * 定时查数据库，发送文件
     * @throws Exception 
     */
    public void findData(){ 
    	
    	try {
    		//查询更新时间在一天之内的（不需要同步的项目）
    		String page = reptileUtil.getPage(BrowserVersion.CHROME,"http://www.bjzgyt.cn/artD/page/5.html");
    		articleService.analysisPage(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }  
}  
