package com.autohome.server.service.impl;

import com.autohome.common.vo.R;
import com.autohome.entity.ForumFavorite;
import com.autohome.server.dao.ForumDao;
import com.autohome.server.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    ForumDao forumDao;

    @Override
    public R selectForumByName(String forum_name) {
        return R.ok(forumDao.selectForumByName(forum_name));
    }

    @Override
    public R selectAllForum() {
        return R.ok(forumDao.selectAllForum());
    }

    @Override
    public R addForum_favorite(ForumFavorite forumFavorite) {
        int i = forumDao.addForum_favorite(forumFavorite);
        if (i > 0) {
            return R.ok("关注成功");
        }else {
            return R.fail("关注失败，请重试");
        }
    }
}

