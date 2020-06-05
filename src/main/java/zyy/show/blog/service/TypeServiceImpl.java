package zyy.show.blog.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import zyy.show.blog.NotFindException;
import zyy.show.blog.dao.TypeRepository;
import zyy.show.blog.polo.Type;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Aaron
 * @date 2020/3/29
 * @Description:
 */
@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    private TypeRepository typeRepository;

    /**
     * @auther: Aaron
     * @date: 2020/3/29 17:54
     * @Description: 保存分类
     */
    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    /**
     * @auther: Aaron
     * @date: 2020/3/29 17:54
     * @Description: 根据id，查询分类
     */
    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).get();
    }

    /**
     * @auther: Aaron
     * @date: 2020/3/29 20:33
     * @Description: 通过type名字查询到type
     */
    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    /**
     * @auther: Aaron
     * @date: 2020/3/29 17:55
     * @Description: 分页查询
     */
    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    /**
     * @auther: Aaron
     * @date: 2020/4/3 21:32
     * @Description: 在blog页面中分类的下拉展示
     */
    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    /**
     * @auther: Aaron
     * @date: 2020/5/3 22:30
     * @param: [size]
     * @Description: 在index页面右侧显示的type数量
     */
    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC,"blogs.size");
        Pageable pageable = PageRequest.of(0,size,sort);
        return typeRepository.findTop(pageable);
    }

    /**
     * @auther: Aaron
     * @date: 2020/3/29 17:56
     * @Description: 根据id先查询实体对象，然后再修改分类
     */
    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeRepository.findById(id).get();
        if (t == null) {
            throw new NotFindException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);
        return typeRepository.save(t);
    }

    /**
     * @auther: Aaron
     * @date: 2020/3/29 17:56
     * @Description: 根据id，删除分类
     */
    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}