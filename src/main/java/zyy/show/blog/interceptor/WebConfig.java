package zyy.show.blog.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Aaron
 * @date 2020/3/29
 * @Description:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())//把定义好的LoginInterceptor加进来
        .addPathPatterns("/admin/**")//admin目录下的全部拦截
        .excludePathPatterns("/admin")//放开admin.html
        .excludePathPatterns("/admin/login");//放开admin/login.html

    }
}
