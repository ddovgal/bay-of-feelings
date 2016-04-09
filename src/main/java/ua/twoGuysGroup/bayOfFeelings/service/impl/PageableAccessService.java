package ua.twoGuysGroup.bayOfFeelings.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.twoGuysGroup.bayOfFeelings.entity.Commentary;
import ua.twoGuysGroup.bayOfFeelings.repository.AdditionRepository;
import ua.twoGuysGroup.bayOfFeelings.repository.CommentaryRepository;
import ua.twoGuysGroup.bayOfFeelings.repository.PostRepository;
import ua.twoGuysGroup.bayOfFeelings.repository.UserRepository;
import ua.twoGuysGroup.bayOfFeelings.service.CommentaryService;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PageableAccessService implements CommentaryService {

    @Autowired
    private CommentaryRepository commentaryRepository;
    @Autowired
    private AdditionRepository additionRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Commentary getById(Long id) {
        return commentaryRepository.findOne(id);
    }

    private Commentary update(Commentary commentary) {
        return commentaryRepository.save(commentary);
    }

    @Override
    public Commentary save(Commentary commentary) {
        commentary.setDatetime(new Date());
        return update(commentary);
    }

    @Override
    public Commentary save(Commentary commentary, Long postId, Long authorId, Long parentId) {
        commentary.setPost(postRepository.findOne(postId));
        commentary.setAuthor(userRepository.findOne(authorId));
        if (parentId != null) commentary.setParent(commentaryRepository.findOne(parentId));
        return save(commentary);
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

    private Commentary changeRatio(Long id, int value) {
        Commentary commentary = getById(id);
        commentary.setRatio(commentary.getRatio() + value);
        return update(commentary);
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
    public Commentary addAddition(Long additionId, Long id) {
        Commentary commentary = getById(id);
        commentary.getAdditions().add(additionRepository.findOne(additionId));
        return update(commentary);
    }

    @Override
    public Commentary editText(String newText, Long id) {
        Commentary commentary = getById(id);
        commentary.setText(newText);
        return update(commentary);
    }

    @Override
    public Page<Commentary> getPageBySpecification(List<Specification<Commentary>> specification, Boolean conjunction, Pageable pageable) {
        return null; //todo
    }
}
