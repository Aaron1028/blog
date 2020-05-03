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

    Tag saveTag(Tag type);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    List<Tag> listTagTop(Integer size);

    List<Tag> listTag(String ids);

    Tag updateTag(Long id, Tag type);

    void deleteTag(Long id);

}
