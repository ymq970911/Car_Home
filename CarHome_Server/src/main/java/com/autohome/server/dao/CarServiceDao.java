package com.autohome.server.dao;

import com.autohome.common.dto.ServiceFirstLevelDto;
import com.autohome.entity.MainLevel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Interface: CarServiceDao
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/08 10:46
 */
@Repository
public interface CarServiceDao {
    int save(String name);

    int delete(Integer id);

    int update(ServiceFirstLevelDto dto);

    ServiceFirstLevelDto selectOne(@Param("id") Integer id);

    List<MainLevel> selectAll();
}
