package cn.zgyt.quartz;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import cn.zgyt.entiry.JobScheduler;
import cn.zgyt.processer.service.NewStoryAnalysisService;
import cn.zgyt.repository.JobSchedulerRepository;

  
@Configuration  
@Component // 此注解必加  
@EnableScheduling // 此注解必加  
public class ScheduleTask {  
	
    private static final Logger LOGGER =  LoggerFactory.getLogger(ScheduleTask.class);
   
    @Autowired
    private JobSchedulerRepository jobSchedulerRepository;
    @Autowired
    private NewStoryAnalysisService newStoryAnalysisService;
    /**
     * 定时查数据库，发送文件
     * @throws Exception 
     */
    public void updateScheduleList(){ 
    	try {
    		List<JobScheduler> ll = jobSchedulerRepository.findByIsExcute(1);
    		if(ll.size()>0) {
    			JobScheduler js = ll.get(0);
        		System.out.println(js);
        		newStoryAnalysisService.analysisPageForList(js);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }  
}  
