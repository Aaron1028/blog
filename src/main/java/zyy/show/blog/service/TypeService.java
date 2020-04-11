package zyy.show.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zyy.show.blog.polo.Type;

import java.util.List;

/**
 * @author Aaron
 * @date 2020/3/29
 * @Description:
 */
public interface TypeService {

    /**
     * @auther: Aaron
     * @date: 2020/3/29 17:54
     * @Description: 保存分类
     */
    Type saveType(Type type);

    /**
     * @auther: Aaron
     * @date: 2020/3/29 17:54
     * @Description: 根据id，查询分类
     */
    Type getType(Long id);

    /**
     * @auther: Aaron
     * @date: 2020/3/29 20:33
     * @Description: 通过type名字查询到type
     */
    Type getTypeByName(String name);

    /**
     * @auther: Aaron
     * @date: 2020/3/29 17:55
     * @Description: 分页查询
     */
    Page<Type> listType(Pageable pageable);

    /**
     * @auther: Aaron
     * @date: 2020/4/3 21:32
     * @Description: 在blog页面中分类的下拉展示
     */
    List<Type> listType();

    /**
     * @auther: Aaron
     * @date: 2020/3/29 17:56
     * @Description: 根据id先查询实体对象，然后再修改分类
     */
    Type updateType(Long id, Type type);

    /**
     * @auther: Aaron
     * @date: 2020/3/29 17:56
     * @Description: 根据id，删除分类
     */
    void deleteType(Long id);

}
