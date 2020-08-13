package com.autohome.server.dao;

import com.autohome.common.dto.PostsDto;
import com.autohome.entity.Posts;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsDao {
    List<PostsDto> selectPostsByName(String title);

    int addPosts(Posts posts);


}
