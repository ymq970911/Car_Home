package com.autohome.api.service;

import com.autohome.common.vo.R;
import com.autohome.entity.ForumFavorite;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

public interface ForumService {

    R selectForumByName(String forum_name);

    R selectAllForum();

    R addForum_favorite(ForumFavorite forumFavorite);
}
