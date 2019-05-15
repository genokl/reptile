//package cn.zgyt.processer.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import cn.zgyt.processer.aoyugeStory.vo.Story;
//import cn.zgyt.processer.repo.StoryChapterRepository;
//import cn.zgyt.processer.repo.StoryRepository;
//import cn.zgyt.utils.ConstantPool;
//
///**
// * 读取文章到缓存
// * @author epc-624
// */
//@Service
//public class StoryUpdateService {
//
//	@Autowired
//	private StoryChapterRepository scRep;
//	@Autowired
//	private StoryRepository sRep;
//
//		@Transactional(rollbackFor = Exception.class )
//		public List<String> saveStoryFromList() throws Exception {
//			Story story = ConstantPool.readToll();
//			sRep.save(story);
//			System.out.println("保存："+story.getStoryTitle());
//			return null;
//		}
//	
//}
