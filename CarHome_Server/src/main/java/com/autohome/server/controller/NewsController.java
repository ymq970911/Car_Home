package com.autohome.server.controller;

import com.autohome.common.dto.NewsDetailsDto;
import com.autohome.common.vo.R;
import com.autohome.server.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Class: NewsController
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/08 15:10
 */
@RestController
@RequestMapping("/server/news")
public class NewsController {

    @Autowired
    private NewsService service;

    /**
     * 新增一个新闻
     *
     * @param dto
     * @return
     */
    @PostMapping("/add.do")
    public R addNews(@RequestBody NewsDetailsDto dto) {
        return service.addNews(dto);
    }

    /**
     * 删除一个新闻
     *
     * @param id 新闻编号
     * @return
     */
    @GetMapping("/del/{id}")
    public R delNews(@PathVariable Integer id) {
        return service.delNews(id);
    }

    /**
     * 更改一个新闻信息
     *
     * @return
     */
    @PostMapping("/upd")
    public R updateNews(@RequestBody NewsDetailsDto dto) {
        return service.updateNews(dto);
    }

    /**
     * 获取全部新闻信息 - 分页
     *
     * @param pageNum  页码
     * @param pageSize 每页数量
     * @return
     */
    @GetMapping("/all")
    public R getAllNewssByPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.getAllNewss(pageNum, pageSize);
    }

    /**
     * 根据编号获取单个新闻名称
     *
     * @return
     */
    @GetMapping("/getNewsById")
    public R getNewsById(Integer id) {
        return service.getNewsById(id);
    }

    /**
     * 根据新闻类型获取该类型下的分页
     *
     * @param pageNum  页码
     * @param pageSize 每页数量
     * @param newsType 新闻类型
     * @return
     */
    @GetMapping("/getNewsByType")
    public R getNewsById(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                         Integer newsType) {
        return service.getNewsByPage(pageNum, pageSize, newsType);
    }
}
