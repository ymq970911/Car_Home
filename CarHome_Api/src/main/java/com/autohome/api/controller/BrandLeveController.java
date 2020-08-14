package com.autohome.api.controller;

import com.autohome.api.service.BrandLeveService;
import com.autohome.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author YMQ
 */
@Api(tags = "汽车品牌查询接口")
@RestController
@RequestMapping("/api/brandlevecontroller/")
public class BrandLeveController {

    @Autowired
    private BrandLeveService service;
    @ApiOperation(value = "查找品牌", notes = "根据name首字母排序")

    @GetMapping("getAllBrandLevel.do")
    public R getAllBrandLevel() {
        return service.getAllBrandLevel();
    }

    @ApiOperation(value = "获取某品牌信息", notes = "根据id查找")
    @GetMapping("getbrandbyId.do/{bid}")
    public R GetBrandById(@PathVariable Integer bid) {
        return service.GetBrandById(bid);
    }

    @ApiOperation(value = "查询某品牌下不同类型的车辆信息")
    @GetMapping("getbrandidandmodellevelAndtype.do/{type}/{model_level}/{bid}")
    public R getBrandIdAndModelLevelAndType(@RequestParam Integer type,@RequestParam  String model_level,@RequestParam  Integer bid) {
        return service.getBrandIdAndModelLevelAndType(type, model_level, bid);
    }

    @ApiOperation(value = "查找某品牌下所有车辆信息")
    @GetMapping("getcarbybrandid.do/{bid}")
    public R getCarByBrandId(@PathVariable Integer bid) {
        System.out.println(bid);
        return service.getCarByBrandId(bid);
    }

    @ApiOperation(value = "热度排行榜" , notes="待完善")
    @GetMapping("leaderboard.do/{bid}")
    public R leaderboard(@PathVariable Integer bid) {
        return service.leaderboard(bid);
    }
}
