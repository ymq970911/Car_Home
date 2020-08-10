package com.autohome.api.controller;

import com.autohome.api.service.NewsService;
import com.autohome.common.dto.NewsDetailsDto;
import com.autohome.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Class: NewsController
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/08 15:10
 */
@Api(tags = "新闻模块接口")
@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsService service;

    /**
     * 新增一个新闻
     *
     * @param dto
     * @return
     */
    @ApiOperation(value = "新增1个新闻", notes = "新增1个新闻，需要传入一个新闻名称")
    @PostMapping("/add")
    public R addNews(@RequestBody NewsDetailsDto dto) {
        return service.addNews(dto);
    }

    /**
     * 删除一个新闻
     *
     * @param id 新闻编号
     * @return
     */
    @ApiOperation(value = "删除1个新闻", notes = "删除1个新闻，需要传入新闻的编号")
    @GetMapping("/del/{id}")
    public R delNews(@PathVariable Integer id) {
        return service.delNews(id);
    }

    /**
     * 更改一个新闻信息
     *
     * @return
     */
    @ApiOperation(value = "修改1个新闻", notes = "修改1个新闻，需要传入新闻编号和新闻名称")
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
    @ApiOperation(value = "获取全部主新闻-分页", notes = "获取全部主新闻信息")
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
    @ApiOperation(value = "根据编号获取新闻", notes = "如果有需要，根据编号获取单个新闻信息")
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
    @ApiOperation(value = "根据类型获取新闻-分页", notes = "根据类型获取对应分类的新闻信息")
    @GetMapping("/getNewsByType")
    public R getNewsById(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                         Integer newsType) {
        return service.getNewsByPage(pageNum, pageSize, newsType);
    }
}
