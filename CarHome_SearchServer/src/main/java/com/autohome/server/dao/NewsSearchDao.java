package com.autohome.server.dao;

import com.autohome.common.dto.NewsDetailsDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Class: NewsSearchDto
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/13 14:59
 */
@Repository
public interface NewsSearchDao {

    List<NewsDetailsDto> searchByKeywords(String keywrods);

}
