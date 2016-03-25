package ua.twoGuysGroup.bayOfFeelings.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.twoGuysGroup.bayOfFeelings.entity.Tag;
import ua.twoGuysGroup.bayOfFeelings.repository.TagRepository;
import ua.twoGuysGroup.bayOfFeelings.service.TagService;

@Service
@Transactional
public class TagServiceSpringDataImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag getById(Long id) {
        return tagRepository.findOne(id);
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void deleteById(Long id) {
        tagRepository.delete(id);
    }

    @Override
    public void delete(Tag tag) {
        tagRepository.delete(tag);
    }
}
