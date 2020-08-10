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

    @GetMapping("getallbrandlevel.do")
    public R getAllCarGeneral() {
        return service.getAllBrandLevel();
    }

    @GetMapping("getbrandbyId.do")
    public R getBrandById(Integer bid) {
        System.out.println(bid);
        return service.getBrandById(bid);
    }

    @GetMapping("getbrandidandmodellevelAndtype.do")
    public R getBrandIdAndModelLevelAndType(Integer type, String model_level, Integer bid) {
        return service.getBrandIdAndModelLevelAndType(type, model_level, bid);
    }

    @GetMapping("getcarbybrandid.do")
    public R getCarByBrandId(Integer bid) {
        return service.getCarByBrandId(bid);
    }
}
