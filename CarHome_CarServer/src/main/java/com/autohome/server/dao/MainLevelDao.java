package com.autohome.server.dao;

import com.autohome.entity.MainLevel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YMQ
 */
@Repository
public interface MainLevelDao {

    List<MainLevel> getAllMainLevel();

    int addMainLevel(String name);
}
