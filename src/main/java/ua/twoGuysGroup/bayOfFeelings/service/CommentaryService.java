package ua.twoGuysGroup.bayOfFeelings.service;

import ua.twoGuysGroup.bayOfFeelings.entity.Commentary;
import ua.twoGuysGroup.bayOfFeelings.service.general.GeneralService;
import ua.twoGuysGroup.bayOfFeelings.service.general.PageableAccessService;

public interface CommentaryService extends GeneralService<Commentary, Long>, PageableAccessService<Commentary> {
    //Commentary getById(Long id);

    //Commentary save(Commentary commentary);

    Commentary save(Commentary commentary, Long postId, Long authorId, Long parentId);

    Commentary replace(Commentary newCommentary, Long id);

    //void deleteById(Long id);

    //void delete(Commentary commentary);

    Commentary incrementRatio(Long id);

    Commentary decrementRatio(Long id);

    Commentary addAddition(Long additionId, Long id);

    Commentary editText(String newText, Long id);
}
