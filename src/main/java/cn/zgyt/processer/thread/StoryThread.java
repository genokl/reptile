package cn.zgyt.processer.thread;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zgyt.processer.service.StoryUpdateService;
import cn.zgyt.utils.ConstantPool;
import cn.zgyt.utils.SpringContextUtil;

public class StoryThread extends Thread {

//	@Autowired
//	private StoryUpdateService storyUpdateService;

	@Override
	public void run() {
		try {
			while (true) {
				if (ConstantPool.getLlSize() > 0) {
					System.out.println(11);
					StoryUpdateService storyUpdateService = (StoryUpdateService) SpringContextUtil.getBean("storyUpdateService");
					storyUpdateService.saveStoryFromList();
					System.out.println(11);
				} else {
					sleep(1000*100);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
