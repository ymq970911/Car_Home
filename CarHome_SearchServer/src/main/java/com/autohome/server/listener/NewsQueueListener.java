package com.autohome.server.listener;

import com.autohome.entity.NewsDetails;
import com.autohome.server.domain.NewsDocument;
import com.autohome.server.service.NewsDocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Job2001
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-24 16:23
 */
@Slf4j
@Component
@RabbitListener(queues = "car-synces")
public class NewsQueueListener {
    @Autowired
    private NewsDocumentService documentService;

    @RabbitHandler
    public void handler(List<NewsDetails> l) {
        log.info("MQ消费者监听数据变化：" + l.size());
        //获取数据 新增到ES
        List<NewsDocument> list = new ArrayList<>(l.size());
        l.stream().forEach(news -> {
            list.add(new NewsDocument(news.getNdid(), news.getTitle(), news.getAuthor(), news.getContent(), news.getNid()));
        });
        documentService.saveBatch(list);
        log.info("MQ消同步完成：" + list.size());
    }
}
