package zyy.show.blog.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import zyy.show.blog.NotFindException;
import zyy.show.blog.dao.BlogRepository;
import zyy.show.blog.polo.Blog;
import zyy.show.blog.util.MarkdownUtils;
import zyy.show.blog.util.MyBeanUtils;
import zyy.show.blog.vo.BlogQuery;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.*;

/**
 * @author Aaron
 * @date 2020/4/3
 * @Description:
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    /**
     * @auther: Aaron
     * @date: 2020/4/3 18:03
     * @param: [id]
     * @Description: 通过id找到blog对象
     */
    @Override
    public Blog getBlog(Long id) {
        return blogRepository.findById(id).get();//不用findOne(id)
    }

    /**
     * @auther: Aaron
     * @date: 2020/5/4 1:36
     * @param: [id]
     * @Description: 获取博客内容，转换格式
     */
    @Transactional
    @Override
    public Blog getAndConvert(Long id) {
        Blog blog = blogRepository.findById(id).get();
        if (blog == null) {
            throw new NotFindException("该博客不存在");
        }
        Blog b = new Blog();
        BeanUtils.copyProperties(blog,b);
        String content = b.getContent();
        b.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        blogRepository.updateViews(id);
        return b;
    }

    /**
     * @auther: Aaron
     * @date: 2020/4/3 18:04
     * @param: [pageable, blog]
     * @Description: 分页查询
     */
    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (!"".equals(blog.getTitle()) && blog.getTitle() != null){
                    predicates.add(cb.like(root.<String>get("title"), "%" + blog.getTitle() + "%"));
                }
                if(blog.getTypeId() != null){
                    predicates.add(cb.equal(root.<String>get("Type").get("id"), blog.getTypeId()));
                }
                if (blog.isRecommend()){
                    predicates.add(cb.equal(root.<Boolean>get("recommend"), blog.isRecommend()));
                }
                cq.where(predicates.toArray(new  Predicate[predicates.size()]));
                return null;
            }
        }, pageable);
    }

    /**
     * @auther: Aaron
     * @date: 2020/4/3 22:26
     * @param: [blog]
     * @Description: 分页查询
     */
    @Override
    public Page<Blog> listBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    /**
     * @auther: Aaron
     * @date: 2020/4/3 23:04
     * @param: [tagId, pageable]
     * @Description:
     */
    @Override
    public Page<Blog> listBlog(Long tagId, Pageable pageable) {
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                Join join = root.join("tags");
                return cb.equal(join.get("id"),tagId);
            }
        },pageable);
    }

    /**
     * @auther: Aaron
     * @date: 2020/5/4 1:03
     * @param: [query, pageable]
     * @Description:
     */
    @Override
    public Page<Blog> listBlog(String query, Pageable pageable) {
        return blogRepository.findByQuery(query,pageable);
    }

    /**
     * @auther: Aaron
     * @date: 2020/5/3 22:01
     * @param: [size]
     * @Description: 首页的推荐博客列表
     */
    @Override
    public List<Blog> listRecommendBlogTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC,"updateTime");
        Pageable pageable = PageRequest.of(0, size, sort);
        return blogRepository.findTop(pageable);
    }

    /**
     * @auther: Aaron
     * @date: 2020/5/3 22:07
     * @Description: 归档页面，展示所有blog
     */
    @Override
    public Map<String, List<Blog>> archiveBlog() {
        List<String> years = blogRepository.findGroupYear();
        Map<String, List<Blog>> map = new HashMap<>();
        for (String year : years) {
            map.put(year, blogRepository.findByYear(year));
        }
        return map;
    }

    /**
     * @auther: Aaron
     * @date: 2020/5/3 22:17
     * @Description: 每个博客的点击数
     */
    @Override
    public Long countBlog() {
        return blogRepository.count();
    }

    /**
     * @auther: Aaron
     * @date: 2020/4/3 18:05
     * @param: [blog]
     * @Description: 新建博客
     */
    @Transactional
    @Override
    public Blog saveBlog(Blog blog) {
        if (blog.getId() == null){
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setViews(0);
        }else {
            blog.setUpdateTime(new Date());
        }
        return blogRepository.save(blog);
    }

    /**
     * @auther: Aaron
     * @date: 2020/4/3 18:06
     * @param: [id, blog]
     * @Description: 更新博客
     */
    @Transactional
    @Override
    public Blog updateBlog(Long id, Blog blog) {
        Blog b = blogRepository.findById(id).get();
        if (id == null){
            throw new NotFindException("该博客不存在");
        }
        BeanUtils.copyProperties(blog,b, MyBeanUtils.getNullPropertyNames(blog));
        b.setUpdateTime(new Date());
        return blogRepository.save(b);
    }

    /**
     * @auther: Aaron
     * @date: 2020/4/3 18:07
     * @param: [id]
     * @Description: 删除博客
     */
    @Transactional
    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
