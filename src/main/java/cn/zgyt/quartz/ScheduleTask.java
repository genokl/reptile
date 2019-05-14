package cn.zgyt.quartz;

import java.util.ArrayList;
import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import cn.zgyt.entiry.JobScheduler;
import cn.zgyt.repository.JobSchedulerRepository;
import cn.zgyt.utils.ConstantPool;

  
@Configuration  
@Component // 此注解必加  
@EnableScheduling // 此注解必加  
public class ScheduleTask {  
	
	
    private static final Logger LOGGER =  LoggerFactory.getLogger(ScheduleTask.class);
    
    @Autowired
    private JobSchedulerRepository jobSchedulerRepository;
    /**
     * 定时查数据库，发送文件
     * @throws Exception 
     */
    public void updateScheduleList(){ 
    	try {
    		List<JobScheduler> alljds = ConstantPool.getAlljds();
    		List<JobScheduler> newjds = new ArrayList<>();
    		if(alljds.size()==0) {//第一次启动
    			List<JobScheduler> all = jobSchedulerRepository.findAll();
    			newjds=all;
    			ConstantPool.setAlljds(all);
    		}else {//以后启动
    			newjds=ConstantPool.getNewjds();	
			}
    		if(newjds.size()>0) {
    			for (int i = 0; i < newjds.size(); i++) {
//    				TaskThread tt=new TaskThread();
//    				tt.setJobDetail(newjds.get(i));
//    				tt.run();
    				
				}
    		}
    		ConstantPool.setNewjds(new ArrayList<JobScheduler>());
    		System.out.println(13232);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }  
}  
