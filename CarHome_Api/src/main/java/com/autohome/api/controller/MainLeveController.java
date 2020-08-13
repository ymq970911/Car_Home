package com.autohome.api.controller;

import com.autohome.common.vo.R;
import com.autohome.api.service.MainLeveService;
import com.autohome.entity.MainLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
  public R getAllMainLevel(){
        return service.getAllMainLevel();
    }
    @PostMapping("addallmainlevel.do")
    public R addMainLevel(@RequestBody String name){
        return service.addMainLevel(name);
    }

}
