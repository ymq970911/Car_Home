package com.autohome.api.service.impl;

import com.autohome.api.service.ForumService;
import com.autohome.common.vo.R;
import com.autohome.entity.ForumFavorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public R selectForumByName(String forum_name) {
        return restTemplate.getForObject("http://evaluateserver/eval/forum/selectPostsByName.do?forum_name=" + forum_name,R.class);
    }

    @Override
    public R selectAllForum() {
        return restTemplate.getForObject("http://evaluateserver/eval/forum/selectAllForum.do", R.class);
    }

    @Override
    public R addForum_favorite(ForumFavorite forumFavorite) {
        return restTemplate.postForObject("http://evaluateserver/eval/forum/addForum_favorite.do",forumFavorite,R.class);
    }
}
