package cn.zgyt.processer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.zgyt.processer.aoyugeStory.vo.StoryChapter;

public interface StoryChapterRepository extends JpaRepository<StoryChapter, Integer>, JpaSpecificationExecutor<StoryChapter> {

	
}
