package zyy.show.blog.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zyy.show.blog.polo.Blog;
import zyy.show.blog.vo.BlogQuery;

/**
 * @author Aaron
 * @date 2020/4/3
 * @Description:
 */
public interface BlogService  {

    /**
     * @auther: Aaron
     * @date: 2020/4/3 18:03
     * @param: [id]
     * @Description:
     */
    Blog getBlog(Long id);

    /**
     * @auther: Aaron
     * @date: 2020/4/3 18:04
     * @param: [pageable, blog]
     * @Description: 分页查询
     */
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    /**
     * @auther: Aaron
     * @date: 2020/4/3 18:05
     * @param: [blog]
     * @Description: 新增blog
     */
    Blog saveBlog(Blog blog);

    /**
     * @auther: Aaron
     * @date: 2020/4/3 18:06
     * @param: [id, blog]
     * @Description: 更新博客
     */
    Blog updateBlog(Long id, Blog blog);

    /**
     * @auther: Aaron
     * @date: 2020/4/3 18:07
     * @param: [id]
     * @Description: 删除博客
     */
    void deleteBlog(Long id);
}
