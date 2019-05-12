package cn.zgyt.processer.aoyugeStory;

import java.util.ArrayList;
import java.util.List;

import cn.zgyt.processer.aoyugeStory.vo.Story;

public class constantPool {
	

	private static List<Story> ll = new ArrayList<Story>();

	
	public List<Story> getLl() {
		return ll;
	}
	public static synchronized void addToLl(Story s) {
		ll.add(s);
	}
	public static synchronized Story readToLl() {
		if(ll.size()>0) {
			Story s = ll.get(0);
			ll.remove(0);
			return s;
		}
		return null;
	}
	
	
}
