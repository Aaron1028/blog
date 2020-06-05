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


    Type saveType(Type type);


    Type getType(Long id);


    Type getTypeByName(String name);


    Page<Type> listType(Pageable pageable);


    List<Type> listType();


    List<Type> listTypeTop(Integer size);


    Type updateType(Long id, Type type);


    void deleteType(Long id);


}
