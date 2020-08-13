package com.autohome.server.dao;

import com.autohome.common.dto.ForumDto;
import com.autohome.entity.ForumFavorite;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumDao {
    List<ForumDto> selectForumByName(String forum_name);

    List<ForumDto> selectAllForum();

    int addForum_favorite(ForumFavorite forumFavorite);
}
