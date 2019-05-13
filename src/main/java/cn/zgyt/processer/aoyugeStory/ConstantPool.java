package cn.zgyt.processer.aoyugeStory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.zgyt.processer.aoyugeStory.vo.Story;

public class ConstantPool {
	

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
	
}
