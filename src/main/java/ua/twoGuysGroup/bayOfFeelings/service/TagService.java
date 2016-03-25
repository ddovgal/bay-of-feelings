package ua.twoGuysGroup.bayOfFeelings.service;

import ua.twoGuysGroup.bayOfFeelings.entity.Tag;

public interface TagService {
    Tag getById(Long id);

    Tag save(Tag tag);

    void deleteById(Long id);

    void delete(Tag tag);
}
