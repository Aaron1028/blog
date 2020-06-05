package zyy.show.blog.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import zyy.show.blog.polo.Comment;

import java.util.List;

/**
 * @author Aaron
 * @date 2020/5/4
 * @Description:
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);
}
