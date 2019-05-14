package cn.zgyt.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.JobDetail;

import cn.zgyt.entiry.JobScheduler;
import cn.zgyt.processer.aoyugeStory.vo.Story;

public class ConstantPool {
	

	private static List<JobScheduler> alljds = new ArrayList<JobScheduler>();
	private static List<JobScheduler> newjds = new ArrayList<JobScheduler>();
	
	private static List<Story> ll = new ArrayList<Story>();
	private static Map<String,Story> mm = new HashMap<String,Story>();

	
	public static Integer getLlSize() {
		return ll.size();
	}
	public static synchronized void addToLl(Story s) {
		if(ll.contains(s)) {
			ll.remove(s);
		}
		ll.add(s);
	}
	public static synchronized Story readToll() {
		if(ll.size()>0) {
			Story s = ll.get(0);
			ll.remove(s);
			return s;
		}
		return null;
	}
	
	public static String getStoryKey(Story s) {
		return s.getStoryTitle()+"-"+s.getStoryAuther();
	}
	public static List<JobScheduler> getAlljds() {
		return alljds;
	}
	public static void setAlljds(List<JobScheduler> alljds) {
		ConstantPool.alljds = alljds;
	}
	public static List<JobScheduler> getNewjds() {
		return newjds;
	}
	public static void setNewjds(List<JobScheduler> newjds) {
		ConstantPool.newjds = newjds;
	}
	
	
	
}
