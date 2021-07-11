package com.lg.mapper;

import com.lg.pojo.Post;

import java.util.List;

public interface PostMapper {
    List<Post> selectOddPostsInKeysList();

    List<Post> selectOddPostsIn();

    List<Post> selectPostIn();

    Post[] findPost();
}
