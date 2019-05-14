package cn.zgyt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zgyt.entiry.JobScheduler;

/**
 *
 */
@RepositoryRestResource(path="jobdetail")
@Transactional(propagation=Propagation.REQUIRED)
public interface JobSchedulerRepository extends JpaRepository<JobScheduler, Integer>{

	List<JobScheduler> findByIsExcute(Integer isExcute);
}
