package com.autohome.server.dao;

import com.autohome.common.dto.NewsDetailsDto;
import com.autohome.common.dto.NewsDetailsIdDto;
import com.autohome.common.vo.R;
import com.autohome.entity.NewsDetails;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Interface: NewsService
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/08 15:12
 */
@Repository
public interface NewsDao {
    int save(NewsDetailsDto dto);

    int delete(Integer id);

    int update(NewsDetailsIdDto dto);

    List<NewsDetailsIdDto> getAllByPage();

    NewsDetailsIdDto getOneById(Integer id);

    List<NewsDetailsIdDto> getAllByTypeAndPage(Integer newsType);
}
