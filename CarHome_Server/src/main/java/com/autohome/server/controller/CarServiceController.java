package com.autohome.server.controller;

import com.autohome.common.dto.ServiceFirstLevelDto;
import com.autohome.common.vo.R;
import com.autohome.server.service.CarServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Class: CarServiceController
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/08 09:50
 */
@RestController
@RequestMapping("/server/carservice")
public class CarServiceController {

    @Autowired
    private CarServiceService service;

    /**
     * 新增一个服务
     *
     * @param name 服务名称
     * @return
     */
    @GetMapping("/addService.do")
    public R addService(String name) {
        return service.addService(name);
    }

    /**
     * 删除一个服务
     *
     * @param id 服务编号
     * @return
     */
    @GetMapping("/delService.do")
    public R delService(Integer id) {
        return service.delService(id);
    }

    /**
     * 更改一个服务信息
     *
     * @return
     */
    @PostMapping("/update.do")
    public R updateService(@RequestBody ServiceFirstLevelDto dto) {
        return service.updateService(dto);
    }

    /**
     * 获取所有服务信息
     *
     * @return
     */
    @GetMapping("/allServices.do")
    public R getAllServices() {
        return service.getAllServices();
    }

    /**
     * 根据编号获取单个服务名称
     *
     * @return
     */
    @GetMapping("/oneService/{id}")
    public R getServiceById(@PathVariable Integer id) {
        return service.getServiceById(id);
    }
}
