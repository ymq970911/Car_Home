package com.autohome.server.controller;

import com.autohome.common.vo.R;
import com.autohome.server.service.BrandLeveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author YMQ
 */
@RestController
@RequestMapping("/carserver/brandlevecontroller/")
public class BrandLeveController {

    @Autowired
    private BrandLeveService service;

    @GetMapping("getAllBrandLevel.do")
    public R getAllBrandLevDto() {
        return service.getAllBrandLevDto();
    }

    @GetMapping("getcarbybrandid.do")
    public R getCarByBrandId( Integer bid) {
        System.out.println(bid);
        return service.getCarByBrandId(bid);
    }

    @GetMapping("getbrandidandmodellevelAndtype.do")
    public R getBrandIdAndModelLevelAndType(Integer type, String model_level, Integer bid) {
        return service.getBrandIdAndModelLevelAndType(type, model_level, bid);
    }

    @GetMapping("GetBrandById.do")
    public R GetBrandById(@RequestParam Integer bid) {
        return service.GetBrandById(bid);
    }

    @GetMapping("leaderboard.do")
    public R leaderboard(@RequestParam Integer bid) {
        return service.leaderboard(bid);
    }
}
