package cn.zgyt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zgyt.processer.aoyugeStory.vo.New;
@Transactional(propagation=Propagation.REQUIRED)
public interface NewRepository extends JpaRepository<New, Integer>, JpaSpecificationExecutor<New> {

	
}
