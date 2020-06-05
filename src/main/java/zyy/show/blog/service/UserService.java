package zyy.show.blog.service;

import zyy.show.blog.polo.User;

/**
 * @author Aaron
 * @date 2020/3/21
 * @Description:
 */
public interface UserService {

    //检查密码用户名是否一直
    User checkUser(String username, String password);
}
