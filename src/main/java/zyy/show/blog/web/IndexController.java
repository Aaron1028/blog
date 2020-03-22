package zyy.show.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Aaron
 * @date 2020/3/20
 * @Description:
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
////        int i =9/0;
//        String blog = null;
//        if(blog == null){
//            throw new NotFindException("blog not exist");//自定义异常
//        }
        return "index";
    }



    @GetMapping("/blog")
    public String blog(){
////        int i =9/0;
//        String blog = null;
//        if(blog == null){
//            throw new NotFindException("blog not exist");//自定义异常
//        }
        return "blog";
    }
}
