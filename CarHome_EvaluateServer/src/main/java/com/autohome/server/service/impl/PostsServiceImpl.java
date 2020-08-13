package com.autohome.server.service.impl;

import com.autohome.common.dto.PostsDto;
import com.autohome.common.vo.R;
import com.autohome.entity.Posts;
import com.autohome.server.dao.PostsDao;
import com.autohome.server.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsServiceImpl implements PostsService {

    @Autowired
    PostsDao postsDao;

    @Override
    public R selectPostsByName(String title) {
        List<PostsDto> posts = postsDao.selectPostsByName(title);
        return R.ok(posts);
    }


    public R addPosts(Posts posts) {

            int i = postsDao.addPosts(posts);
            if (i > 0) {
                return R.ok("发表成功");
            }else {
            return R.fail("商品添加失败，请重新尝试");
        }
    }
}