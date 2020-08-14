package com.autohome.api.service;

import com.autohome.common.vo.R;
import com.autohome.entity.Posts;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface PostsService {
    @GetMapping("selectPostsByName")
    R selectPostsByName(String title);


    @PostMapping("addPosts")
    R addPosts(Posts posts);

}
