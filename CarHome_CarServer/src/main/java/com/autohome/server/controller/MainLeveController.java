package com.autohome.server.controller;

import com.autohome.common.vo.R;
import com.autohome.entity.MainLevel;
import com.autohome.server.service.BrandLeveService;
import com.autohome.server.service.MainLeveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author YMQ
 */
@RestController
@RequestMapping("/carserver/mainlevecontroller/")
public class MainLeveController {

    @Autowired
    private MainLeveService service;
@GetMapping("getallmainlevel.do")
  public R addAllMainLevel(){
        return service.getAllMainLevel();
    }

@PostMapping("addmainlevel.do")
    public R addMainLevel(@RequestBody String name){
        return service.addMainLevel(name);
    }

}
