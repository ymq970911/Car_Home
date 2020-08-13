package com.autohome.server.controller;

import com.autohome.common.vo.R;
import com.autohome.entity.MainLevel;
import com.autohome.server.service.CarLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Class: CarLevelController
 * @Description: 首页汽车主分类信息CRUD
 * @Author: Jerry(姜源)
 * @Create: 2020/08/07 14:59
 */
@RestController
@RequestMapping("/server/carlevel")
public class CarLevelController {

    @Autowired
    private CarLevelService service;

    /**
     * 新增一个分类
     *
     * @param name 分类名称
     * @return
     */
    @GetMapping("/addLevel.do")
    public R addLevel(String name) {
        return service.addLevel(name);
    }

    /**
     * 删除一个分类
     *
     * @param id 分类编号
     * @return
     */
    @GetMapping("/delLevel.do")
    public R delLevel(Integer id) {
        return service.delLevel(id);
    }

    /**
     * 更改一个分类信息
     *
     * @return
     */
    @PostMapping("/update.do")
    public R updateLevel(@RequestBody MainLevel mainLevel) {
        return service.updateLevel(mainLevel);
    }

    /**
     * 获取所有分类信息
     *
     * @return
     */
    @GetMapping("/allLevels.do")
    public R getAllLevels() {
        return service.getAllLevels();
    }

    /**
     * 根据编号获取单个分类信息
     *
     * @return
     */
    @GetMapping("/oneLevel.do")
    public R getLevelById(Integer id) {
        return service.getLevelById(id);
    }
}
