package zyy.show.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import zyy.show.blog.polo.Blog;

/**
 * @author Aaron
 * @date 2020/4/3
 * @Description:
 */
public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

}
