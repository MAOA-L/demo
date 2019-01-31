package top.cyanzoy.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.cyanzoy.demo.bean.Resource;
import top.cyanzoy.demo.bean.Role;

import java.util.List;

/**
 * top.cyanzoy.demo.dao
 * Create By 10993 on 2019/1/17 23:00
 */
public interface ResourceMapper extends JpaRepository<Resource, Integer> {

    List<Resource> findByUrl(String url);

    Resource getResourceByUrl(String url);

    List<Resource> getResourcesById(Integer id);

//    @Query(value = "sql")
//    public List<Resource> findByIdaAndUrl()

}
