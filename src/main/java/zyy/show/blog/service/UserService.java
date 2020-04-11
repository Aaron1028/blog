package zyy.show.blog.service;

import zyy.show.blog.polo.User;

/**
 * @author Aaron
 * @date 2020/3/21
 * @Description:
 */
public interface UserService {

    /**
     * @auther: Aaron
     * @date: 2020/3/21 18:44
     * @param: [username, password]
     * @Description:
     */
    User checkUser(String username, String password);
}
