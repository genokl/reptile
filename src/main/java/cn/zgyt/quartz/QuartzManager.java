package cn.zgyt.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;

import cn.zgyt.entiry.JobScheduler;
 
public class QuartzManager {
	private Scheduler scheduler;
        
	//调度数据是否在启动时已被加载标示
	public static boolean SCHEDULEJOB_LIST_BOOLEAN = false;
 
	//定时启动时查询数据库标示
	public static boolean SCHEDULEJOB_ADD_BOOLEAN = false;
 
 
 
	/**
	 * 
	 * 
	   TODO - 添加定时任务
	   @param jobClass 定是组件class
	   @param sc 定时组件基类bean
	   2017年1月4日
	   mazkc
	 */
	public void addJob(Class jobClass,JobScheduler sc) {
		try {
			// 任务名，任务组，任务执行类
			JobDetail jobDetail = JobBuilder.newJob(jobClass)
					.withIdentity(sc.getJobName(), sc.getJobGroup()).build();
 
			// 触发器
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder
					.newTrigger();
			// 触发器名,触发器组
			triggerBuilder.withIdentity(sc.getTrigget(), sc.getTriggetGroup());
			triggerBuilder.startNow();
			// 触发器时间设定
			triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(sc.getCronExpression()));
			// 创建Trigger对象
			CronTrigger trigger = (CronTrigger) triggerBuilder.build();
			jobDetail.getJobDataMap().put(JobScheduler.JOB_PARAM, sc);
			// 调度容器设置JobDetail和Trigger
			scheduler.scheduleJob(jobDetail, trigger);
			// 启动
			if (!scheduler.isShutdown()) {
				scheduler.start();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
 
	/**
	 * @Description: 修改一个任务的触发时间
	 * 
	 * @param jobName
	 * @param jobGroupName
	 * @param triggerName
	 *            触发器名
	 * @param triggerGroupName
	 *            触发器组名
	 * @param cron
	 *            时间设置，参考quartz说明文档
	 */
	public void modifyJobTime(String jobName, String jobGroupName,
			String triggerName, String triggerGroupName, String cron) {
		try {
			TriggerKey triggerKey = TriggerKey.triggerKey(triggerName,
					triggerGroupName);
			CronTrigger trigger = (CronTrigger) scheduler
					.getTrigger(triggerKey);
			if (trigger == null) {
				return;
			}
 
			String oldTime = trigger.getCronExpression();
			if (!oldTime.equalsIgnoreCase(cron)) {
				/** 方式一 ：调用 rescheduleJob 开始 */
				// 触发器
				TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder
						.newTrigger();
				// 触发器名,触发器组
				triggerBuilder.withIdentity(triggerName, triggerGroupName);
				triggerBuilder.startNow();
				// 触发器时间设定
				triggerBuilder.withSchedule(CronScheduleBuilder
						.cronSchedule(cron));
				// 创建Trigger对象
				trigger = (CronTrigger) triggerBuilder.build();
				// 方式一 ：修改一个任务的触发时间
				scheduler.rescheduleJob(triggerKey, trigger);
				/** 方式一 ：调用 rescheduleJob 结束 */
 
				/** 方式二：先删除，然后在创建一个新的Job */
				// JobDetail jobDetail =
				// scheduler.getJobDetail(JobKey.jobKey(jobName, jobGroupName));
				// Class<? extends Job> jobClass = jobDetail.getJobClass();
				// removeJob(jobName, jobGroupName, triggerName,
				// triggerGroupName);
				// addJob(jobName, jobGroupName, triggerName, triggerGroupName,
				// jobClass, cron);
				/** 方式二 ：先删除，然后在创建一个新的Job */
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
 
	/**
	 * @Description: 移除一个任务
	 * 
	 * @param jobName
	 * @param jobGroupName
	 * @param triggerName
	 * @param triggerGroupName
	 */
	public void removeJob(String jobName, String jobGroupName,
			String triggerName, String triggerGroupName) {
		try {
			TriggerKey triggerKey = TriggerKey.triggerKey(triggerName,
					triggerGroupName);
			scheduler.pauseTrigger(triggerKey);// 停止触发器
			scheduler.unscheduleJob(triggerKey);// 移除触发器
			scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));// 删除任务
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
 
	/**
	 * @Description:启动所有定时任务
	 */
	public void startJobs() {
		try {
			scheduler.start();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
 
	/**
	 * @Description:关闭所有定时任务
	 */
	public void shutdownJobs() {
		try {
			if (!scheduler.isShutdown()) {
				scheduler.shutdown();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
 
	public Scheduler getScheduler() {
		return scheduler;
	}
 
	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
}
