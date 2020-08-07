package com.autohome.server.dao;

import com.autohome.entity.MainLevel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Interface: CarLevelDao
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/07 15:02
 */
@Repository
public interface CarLevelDao {

    int save(String levelName);

    int delete(Integer id);

    int update(MainLevel mainLevel);

    MainLevel selectOne(@Param("id") Integer id);

    List<MainLevel> selectAll();

}
