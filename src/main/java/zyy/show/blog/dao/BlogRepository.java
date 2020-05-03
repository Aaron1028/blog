package zyy.show.blog.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import zyy.show.blog.polo.Blog;

import java.util.List;

/**
 * @author Aaron
 * @date 2020/4/3
 * @Description:
 */
public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

    @Query("select b from Blog b where b.recommend = true ")
    List<Blog> findTop(Pageable pageable);
}
