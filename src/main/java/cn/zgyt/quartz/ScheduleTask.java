//package cn.zgyt.quartz;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.stereotype.Component;
//
//import cn.zgyt.processer.service.AoyugeStoryService;  
//  
//@Configuration  
//@Component // 此注解必加  
//@EnableScheduling // 此注解必加  
//public class ScheduleTask {  
//	
//    private static final Logger LOGGER =  LoggerFactory.getLogger(ScheduleTask.class);
//    
//    @Autowired
//    private AoyugeStoryService aoyugeStoryService;
//    /**
//     * 定时查数据库，发送文件
//     * @throws Exception 
//     */
//    public void findData(){ 
//    	
//    	try {
//    		//查询更新时间在一天之内的（不需要同步的项目）
////    		aoyugeStoryService.analysisPageForTotal("http://www.aoyuge.com/fenlei-3-1.html", "http://www.aoyuge.com", "","都市言情");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    	
//    }  
//}  
