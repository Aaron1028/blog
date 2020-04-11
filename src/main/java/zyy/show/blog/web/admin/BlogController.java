package zyy.show.blog.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zyy.show.blog.polo.Blog;
import zyy.show.blog.service.BlogService;

import org.springframework.data.domain.Pageable;
import zyy.show.blog.service.TypeService;
import zyy.show.blog.vo.BlogQuery;

/**
 * @author Aaron
 * @date 2020/3/28
 * @Description:
 * */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/blogs")
    public String blog(@PageableDefault(size = 3, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                                   Pageable pageable, BlogQuery blog, Model model){
        model.addAttribute("types", typeService.listType());
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        return "admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size = 3, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                               Pageable pageable, BlogQuery blog, Model model){
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        return "admin/blogs : blogList";//返回blogs页面下的一个blogList片段
    }
}
