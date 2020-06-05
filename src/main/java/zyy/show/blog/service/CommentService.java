package zyy.show.blog.service;

import zyy.show.blog.polo.Comment;

import java.util.List;

/**
 * @author Aaron
 * @date 2020/5/4
 * @Description:
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
