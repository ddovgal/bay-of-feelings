package ua.twoGuysGroup.bayOfFeelings.service;

import ua.twoGuysGroup.bayOfFeelings.entity.Post;

public interface PostService {
    Post getById(Long id);

    Post save(Post post);

    Post save(Post post, Long authorId, String category);

    Post addTag(Long tagId, Long postId);

    Post removeTag(Long tagId, Long postId);

    Post replace(Post newPost, Long id);

    void deleteById(Long id);

    void delete(Post post);

    Post incrementRatio(Long id);

    Post decrementRatio(Long id);
    //Post addCommentary(Commentary commentary, Long id);

    Post addAddition(Long additionId, Long id);

    Post editText(String newText, Long id);
}
