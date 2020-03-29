package zyy.show.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import zyy.show.blog.polo.Type;

/**
 * @author Aaron
 * @date 2020/3/29
 * @Description:
 */
public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);
}
