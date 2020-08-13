package com.autohome.server.service.impl;

import com.autohome.common.dto.NewsDetailsDto;
import com.autohome.common.vo.R;
import com.autohome.server.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Job2001
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-24 11:42
 */
@Service
@Slf4j
public class NewsServiceImpl implements NewsService {
    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Override
    public R importData(NewsDetailsDto dto) {
        List<Object> list = new ArrayList<>();
        list.add(dto);
        //基于mq实现消息的发送
        rabbitTemplate.convertAndSend("car-synces", list);
        return R.fail("批量导入失败！");
    }

}
