package zyy.show.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//本地环境
//@SpringBootApplication
//public class BlogApplication  {
//
//    public static void main(String[] args) {
//        SpringApplication.run(BlogApplication.class, args);
//    }
//
//}

//linux下
@SpringBootApplication
public class BlogApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}