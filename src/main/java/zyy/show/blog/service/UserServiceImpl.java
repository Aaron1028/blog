package zyy.show.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zyy.show.blog.dao.UserRepository;
import zyy.show.blog.polo.User;
import zyy.show.blog.util.MD5Utils;

/**
 * @author Aaron
 * @date 2020/3/21
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
