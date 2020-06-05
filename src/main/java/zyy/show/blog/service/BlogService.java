package zyy.show.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zyy.show.blog.polo.Blog;
import zyy.show.blog.vo.BlogQuery;

import java.util.List;
import java.util.Map;

/**
 * @author Aaron
 * @date 2020/4/3
 * @Description:
 */
public interface BlogService  {
    //通过id找到blog对象
    Blog getBlog(Long id);

    //获取博客内容，转换格式
    Blog getAndConvert(Long id);

    //分页查询
    Page<Blog> listBlog(Pageable pageable);
    Page<Blog> listBlog(Long tagId,Pageable pageable);
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);
    Page<Blog> listBlog(String query,Pageable pageable);

    //首页的推荐博客列表
    List<Blog> listRecommendBlogTop(Integer size);

    //归档页面，展示所有blog
    Map<String,List<Blog>> archiveBlog();

    //每个博客的点击数
    Long countBlog();

    //新建博客
    Blog saveBlog(Blog blog);

    //更新博客
    Blog updateBlog(Long id, Blog blog);

    //更新
    void deleteBlog(Long id);
}
