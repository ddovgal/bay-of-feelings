package ua.twoGuysGroup.bayOfFeelings.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.twoGuysGroup.bayOfFeelings.entity.Post;
import ua.twoGuysGroup.bayOfFeelings.repository.PostRepository;
import ua.twoGuysGroup.bayOfFeelings.service.PostService;

@Service
@Transactional
public class PostServiceSpringDataImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Post getById(Long id) {
        return postRepository.findOne(id);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
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

    public Post changeRatio(Long id, int value) {
        Post post = getById(id);
        post.setRatio(post.getRatio() + value);
        return save(post);
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
}
