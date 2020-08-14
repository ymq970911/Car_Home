package com.autohome.server.controller;

import com.autohome.common.vo.R;
import com.autohome.common.dto.UsedCarGeneralDto;
import com.autohome.server.service.UsedCarService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: car_home
 * @description:
 * @author: ztk
 * @create: 2020-08-10 02:01
 **/

@Api(tags = "二手车概况")
@RequestMapping("/server/usedcar/general")
@RestController
public class UsedCarController {
    @Autowired
    private UsedCarService usedCarService;

    @PostMapping("/sysdel.do/{uniqueId}")
    public R deleteUsedCarBySystem(@PathVariable Integer uniqueId) {
        return usedCarService.deleteUsedCarBySystem(uniqueId);
    }

    @PostMapping("/userdel.do/{uid}/{cid}/{uniqueId}")
    public R deleteUsedCarByUser(@PathVariable Integer uid, @PathVariable Integer cid, @PathVariable Integer uniqueId) {
        return usedCarService.deleteUsedCarByUser(uid,cid,uniqueId);
    }

    /**
     *
     * 其中属性，uid，cid，uniqueId为必填，其余提交即修改，不提交则不修改
     * @param usedCarGeneralDto
     * @return
     */
    @PostMapping("/update.do")
    public R updateUsedCarByUser(@RequestBody UsedCarGeneralDto usedCarGeneralDto) {
        return usedCarService.updateUsedCarByUser(usedCarGeneralDto);
    }

    @GetMapping("/getall.do")
    public R getAllUsedCar() {
        return usedCarService.getAllUsedCar();
    }

    @PostMapping("/publish.do/{uid}/{cid}/{uniqueId}")
    public R updateUsedCarFlagToPublish(@PathVariable Integer uid, @PathVariable Integer cid, @PathVariable Integer uniqueId) {
        return usedCarService.updateUsedCarFlag(cid, uid, uniqueId);
    }

    @GetMapping(value = {"/getuser.do/{uid}","/getuser.do/{uid}/{cid}","/getuser.do/{uid}/{cid}/{uniqueId}"})
    public R getUserCar(@PathVariable Integer uid, @PathVariable(required = false) Integer cid, @PathVariable(required = false) Integer uniqueId) {
        return usedCarService.getUserUsedCar(uid, cid, uniqueId);
    }



}
