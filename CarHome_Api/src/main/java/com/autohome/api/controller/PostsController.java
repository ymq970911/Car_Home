package com.autohome.api.controller;


import com.autohome.api.service.PostsService;
import com.autohome.common.vo.R;
import com.autohome.entity.Posts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "帖子功能接口")
@RestController
@RequestMapping("api/posts/")
public class PostsController {

    @Autowired
    private PostsService postsService;

    @ApiOperation(value = "通过名称查询帖子", notes = "通过帖子名称查询对应所有帖子")
    @GetMapping("selectPostsByName")
    public R selectPostsByName(String title){

        return R.ok(postsService.selectPostsByName(title));
    }

    @ApiOperation(value = "新增一篇帖子", notes = "新增一篇帖子内容")
    @PostMapping("addPosts")
    public R addPosts(Posts posts){

        return R.ok(postsService.addPosts(posts));
    }
}
