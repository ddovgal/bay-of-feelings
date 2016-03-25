package ua.twoGuysGroup.bayOfFeelings.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.twoGuysGroup.bayOfFeelings.entity.Addition;
import ua.twoGuysGroup.bayOfFeelings.entity.Commentary;
import ua.twoGuysGroup.bayOfFeelings.repository.CommentaryRepository;
import ua.twoGuysGroup.bayOfFeelings.service.CommentaryService;

@Service
@Transactional
public class CommentaryServiceSpringDataImpl implements CommentaryService {

    @Autowired
    private CommentaryRepository commentaryRepository;

    @Override
    public Commentary getById(Long id) {
        return commentaryRepository.findOne(id);
    }

    @Override
    public Commentary save(Commentary commentary) {
        return null;
    }

    @Override
    public Commentary replace(Commentary newCommentary, Long id) {
        newCommentary.setId(id); //todo unchecked
        return save(newCommentary);
    }

    @Override
    public void deleteById(Long id) {
        commentaryRepository.delete(id);
    }

    @Override
    public void delete(Commentary commentary) {
        commentaryRepository.delete(commentary);
    }

    public Commentary changeRatio(Long id, int value) {
        Commentary commentary = getById(id);
        commentary.setRatio(commentary.getRatio() + value);
        return save(commentary);
    }

    @Override
    public Commentary incrementRatio(Long id) {
        return changeRatio(id, 1);
    }

    @Override
    public Commentary decrementRatio(Long id) {
        return changeRatio(id, -1);
    }

    @Override
    public Commentary addAddition(Addition addition, Long id) {
        Commentary commentary = getById(id);
        commentary.getAdditions().add(addition);
        return save(commentary);
    }
}
