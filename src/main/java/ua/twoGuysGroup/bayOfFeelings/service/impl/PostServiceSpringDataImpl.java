package ua.twoGuysGroup.bayOfFeelings.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.twoGuysGroup.bayOfFeelings.entity.Post;
import ua.twoGuysGroup.bayOfFeelings.repository.*;
import ua.twoGuysGroup.bayOfFeelings.service.PostService;

import java.util.Date;

@Service
@Transactional
public class PostServiceSpringDataImpl implements PostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    private AdditionRepository additionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostCategoryRepository postCategoryRepository;
    @Autowired
    private TagRepository tagRepository;

    @Override
    public Post getById(Long id) {
        return postRepository.findOne(id);
    }

    private Post update(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post save(Post post) {
        post.setDatetime(new Date());
        return update(post);
    }

    @Override
    public Post save(Post post, Long authorId, String category) {
        post.setAuthor(userRepository.findOne(authorId));
        post.setCategory(postCategoryRepository.findOne(category));
        return save(post);
    }

    @Override
    public Post replace(Post newPost, Long id) {
        newPost.setId(id); //todo unchecked
        return save(newPost);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.delete(id);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    private Post changeRatio(Long id, int value) {
        Post post = getById(id);
        post.setRatio(post.getRatio() + value);
        return update(post);
    }

    @Override
    public Post incrementRatio(Long id) {
        return changeRatio(id, 1);
    }

    @Override
    public Post decrementRatio(Long id) {
        return changeRatio(id, -1);
    }

    /*@Override
    public Post addCommentary(Commentary commentary, Long id) {
        Post post = getById(id);
        post.getCommentaries().add(commentary);
        return save(post);
    }*/

    @Override
    public Post addTag(Long tagId, Long postId) {
        Post post = getById(postId);
        post.getTags().add(tagRepository.findOne(tagId));
        return update(post);
    }

    @Override
    public Post removeTag(Long tagId, Long postId) {
        Post post = getById(postId);
        post.getTags().add(tagRepository.findOne(tagId));
        return update(post);
    }

    @Override
    public Post addAddition(Long additionId, Long id) {
        Post post = getById(id);
        post.getAdditions().add(additionRepository.findOne(additionId));
        return update(post);
    }

    @Override
    public Post editText(String newText, Long id) {
        Post post = getById(id);
        post.setText(newText);
        return update(post);
    }
}
