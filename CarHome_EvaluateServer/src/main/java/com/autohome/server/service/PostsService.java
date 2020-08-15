package com.autohome.server.service;

import com.autohome.common.vo.R;
import com.autohome.entity.Posts;

public interface PostsService {
    R selectPostsByName(String title);

    R addPosts(Posts posts);

}
