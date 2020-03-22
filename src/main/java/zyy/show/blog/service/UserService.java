package zyy.show.blog.service;

import zyy.show.blog.polo.User;

/**
 * @author Aaron
 * @date 2020/3/21
 * @Description:
 */
public interface UserService {

    User checkUser(String username, String password);
}
