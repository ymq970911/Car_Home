package com.autohome.api.controller;


import com.autohome.api.service.PostsService;
import com.autohome.common.vo.R;
import com.autohome.entity.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/posts/")
public class PostsController {

    @Autowired
    private PostsService postsService;

    @GetMapping("selectPostsByName")
    public R selectPostsByName(String title){

        return R.ok(postsService.selectPostsByName(title));
    }

    @PostMapping("addPosts")
    public R addPosts(Posts posts){

        return R.ok(postsService.addPosts(posts));
    }
}
