package com.autohome.api.controller;

import com.autohome.api.service.ForumService;
import com.autohome.common.vo.R;
import com.autohome.entity.ForumFavorite;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "论坛功能模块")
@RestController
@RequestMapping("api/forum/")
public class ForumController {
    @Autowired
    private ForumService forumService;

    @ApiOperation(value = "论坛名称查询论坛", notes = "通过论坛名称查询论坛")
    @GetMapping("selectForumByName.do")
    public R selectForumByName(String forum_name) {
        return forumService.selectForumByName(forum_name);
    }

    @ApiOperation(value = "查询所有论坛信息", notes = "查询所有已创建的论坛信息")
    @GetMapping("selectAllForum.do")
    public R selectAllForum() {
        return forumService.selectAllForum();
    }

    @ApiOperation(value = "新增一个论坛版块", notes = "新增一个论坛版块")
    @PostMapping("addForum_favorite.do/{forumFavorite}")
    public R addForum_favorite(@RequestBody ForumFavorite forumFavorite) {
        return forumService.addForum_favorite(forumFavorite);
    }
}
