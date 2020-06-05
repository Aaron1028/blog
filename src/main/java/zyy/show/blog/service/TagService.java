package zyy.show.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zyy.show.blog.polo.Tag;

import java.util.List;

/**
 * @author Aaron
 * @date 2020/5/3
 * @Description:
 */
public interface TagService {
    //新增标签
    Tag saveTag(Tag type);

    //通过id找标签
    Tag getTag(Long id);

    //通过名称找标签
    Tag getTagByName(String name);

    //得到所有标签
    List<Tag> listTag();
    //通过Ids得到所有标签
    List<Tag> listTag(String ids);
    //分页展示所有标签
    Page<Tag> listTag(Pageable pageable);

    //得到出现次数最多的标签
    List<Tag> listTagTop(Integer size);

    //更新标签
    Tag updateTag(Long id, Tag type);

    //删除标签
    void deleteTag(Long id);
}
