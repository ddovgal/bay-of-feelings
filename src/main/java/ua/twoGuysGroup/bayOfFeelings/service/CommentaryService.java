package ua.twoGuysGroup.bayOfFeelings.service;

import ua.twoGuysGroup.bayOfFeelings.entity.Addition;
import ua.twoGuysGroup.bayOfFeelings.entity.Commentary;

public interface CommentaryService {
    Commentary getById(Long id);

    Commentary save(Commentary commentary);

    Commentary replace(Commentary newCommentary, Long id);

    void deleteById(Long id);

    void delete(Commentary commentary);

    Commentary incrementRatio(Long id);

    Commentary decrementRatio(Long id);

    Commentary addAddition(Addition addition, Long id);
}
