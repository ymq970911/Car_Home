package com.autohome.server.controller;

import com.autohome.common.dto.NewsDetailsDto;
import com.autohome.common.vo.R;
import com.autohome.server.service.NewsDocumentService;
import com.autohome.server.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: Job2001
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-24 11:56
 */
@Api(tags = "搜索模块接口 - ES")
@RestController
//@CrossOrigin
@RequestMapping("/search/news")
public class NewsController {
    @Autowired
    private NewsService service;
    @Autowired
    private NewsDocumentService documentService;

    @PostMapping("/upload.do")
    public R upload(@RequestBody NewsDetailsDto dto) {
        return R.ok(service.importData(dto));
    }

    @GetMapping("/essearch.do")
    public R page(String msg, int page, int limit) {
        return R.ok(documentService.queryPage(msg, page, limit));
    }

    @GetMapping("/all.do")
    public R all() {
        return R.ok(documentService.all());
    }

    @DeleteMapping("/delall.do")
    public R delAll() {
        return R.ok(documentService.delAll());
    }

}
