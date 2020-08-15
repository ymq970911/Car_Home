package com.autohome.server.controller;

import com.autohome.common.vo.R;
import com.autohome.entity.ForumFavorite;
import com.autohome.server.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eval/forum/")
public class ForumController {
    @Autowired
    ForumService service;

    @GetMapping("selectForumByName.do")
    public R selectForumByName(String forum_name){
        return service.selectForumByName(forum_name);
    }

    @GetMapping("selectAllForum.do")
    public R selectAllForum(){
        return service.selectAllForum();
    }

    @PostMapping("addForum_favorite.do")
    public R addForum_favorite( ForumFavorite forumFavorite){
        return service.addForum_favorite(forumFavorite);
    }
}
