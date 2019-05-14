package cn.zgyt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.zgyt.processer.aoyugeStory.vo.Story;

public interface StoryRepository extends JpaRepository<Story, Integer>, JpaSpecificationExecutor<Story> {

	
	public Story findByStoryAutherAndStoryTitle(String storyAuther,String storyTitle);
}
