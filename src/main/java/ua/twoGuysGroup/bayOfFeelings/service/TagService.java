package ua.twoGuysGroup.bayOfFeelings.service;

import ua.twoGuysGroup.bayOfFeelings.entity.Tag;
import ua.twoGuysGroup.bayOfFeelings.service.general.GeneralService;
import ua.twoGuysGroup.bayOfFeelings.service.general.PageableAccessService;

public interface TagService extends GeneralService<Tag, Long>, PageableAccessService<Tag> {
    //Tag getById(Long id);

    //Tag save(Tag tag);

    //void deleteById(Long id);

    //void delete(Tag tag);
}
