package com.autohome.server.controller;

import com.autohome.common.vo.R;
import com.autohome.entity.Posts;
import com.autohome.server.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("evaluateserver/posts/")
public class PostsController {
    @Autowired
    PostsService postsService;

    @GetMapping("selectPostsByName.do")
    public R selectPostsByName(String title) {

        return R.ok(postsService.selectPostsByName(title));
    }

    @PostMapping("addPosts.do")
    public R addPosts(Posts posts) {

        return R.ok(postsService.addPosts(posts));
    }
}
