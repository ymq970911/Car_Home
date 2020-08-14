package com.autohome.server.service;

import com.autohome.common.vo.R;
import com.autohome.entity.ForumFavorite;
import org.springframework.web.bind.annotation.RequestBody;

public interface ForumService {
    R selectForumByName(String forum_name);

    R selectAllForum();

    R addForum_favorite(@RequestBody ForumFavorite forumFavorite);
}
