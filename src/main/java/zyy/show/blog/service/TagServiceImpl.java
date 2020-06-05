package zyy.show.blog.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zyy.show.blog.NotFindException;
import zyy.show.blog.dao.TagRepository;
import zyy.show.blog.polo.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aaron
 * @date 2020/5/3
 * @Description:
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;

    /**
     * @auther: Aaron
     * @date: 2020/5/4 18:09
     * @param: [tag]
     * @return: zyy.show.blog.polo.Tag
     * @Description: 新增标签
     */
    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    /**
     * @auther: Aaron
     * @date: 2020/5/4 18:10
     * @param: [id]
     * @return: zyy.show.blog.polo.Tag
     * @Description: 通过id找标签
     */
    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagRepository.findById(id).get();
    }

    /**
     * @auther: Aaron
     * @date: 2020/5/4 18:10
     * @param: [name]
     * @return: zyy.show.blog.polo.Tag
     * @Description: 通过name找标签
     */
    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    /**
     * @auther: Aaron
     * @date: 2020/5/4 18:11
     * @param: [pageable]
     * @return: zyy.show.blog.polo.Tag
     * @Description: 分页展示所有标签
     */
    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    /**
     * @auther: Aaron
     * @date: 2020/5/4 18:11
     * @return: java.util.List<zyy.show.blog.polo.Tag>
     * @Description: 得到所有标签
     */
    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }

    /**
     * @auther: Aaron
     * @date: 2020/5/4 18:12
     * @param: [size]
     * @return: java.util.List<zyy.show.blog.polo.Tag>
     * @Description: 展示创建时间最新的标签
     */
    @Override
    public List<Tag> listTagTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC,"blogs.size");
        Pageable pageable = PageRequest.of(0, size, sort);
        return tagRepository.findTop(pageable);
    }

    /**
     * @auther: Aaron
     * @date: 2020/5/4 18:13
     * @param: [ids]
     * @return: java.util.List<zyy.show.blog.polo.Tag>
     * @Description:
     */
    @Override
    public List<Tag> listTag(String ids) { //1,2,3
        return tagRepository.findAll();
    }

    /**
     * @auther: Aaron
     * @date: 2020/5/4 18:15
     * @param: [ids]
     * @return: java.util.List<java.lang.Long>
     * @Description:
     */
    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i=0; i < idarray.length;i++) {
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }

    /**
     * @auther: Aaron
     * @date: 2020/5/4 18:15
     * @param: [id, tag]
     * @return: zyy.show.blog.polo.Tag
     * @Description: 更新标签
     */
    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagRepository.findById(id).get();
        if (t == null) {
            throw new NotFindException("不存在该标签");
        }
        BeanUtils.copyProperties(tag,t);
        return tagRepository.save(t);
    }

    /**
     * @auther: Aaron
     * @date: 2020/5/4 18:16
     * @param: [id]
     * @Description: 删除标签
     */
    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
