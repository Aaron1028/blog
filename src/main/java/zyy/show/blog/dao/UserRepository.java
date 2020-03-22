package zyy.show.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import zyy.show.blog.polo.User;

/**
 * @author Aaron
 * @date 2020/3/21
 * @Description:
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username, String password);//根据用户名和密码查询数据库
}
