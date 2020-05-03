package zyy.show.blog.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import zyy.show.blog.polo.Tag;

import java.util.List;

/**
 * @author Aaron
 * @date 2020/5/3
 * @Description:
 */
public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findByName(String name);

    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}

