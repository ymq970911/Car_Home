package com.autohome.api.service.impl;

import com.autohome.api.service.PostsService;
import com.autohome.common.vo.R;
import com.autohome.entity.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostsServiceImpl implements PostsService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public R selectPostsByName(String title) {
        return restTemplate.getForObject("http://evaluateserver/evaluateserver/posts/selectPostsByName.do?title=" + title, R.class);
    }

    @Override
    public R addPosts(Posts posts) {
        return restTemplate.postForObject("http://evaluateserver/evaluateserver/posts/addPosts.do",posts,R.class);
    }
}
