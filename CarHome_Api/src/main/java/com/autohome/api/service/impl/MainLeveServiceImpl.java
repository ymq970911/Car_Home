package com.autohome.api.service.impl;




import com.autohome.api.service.MainLeveService;
import com.autohome.common.vo.R;
import com.autohome.entity.MainLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author YMQ
 */
@Service
public class MainLeveServiceImpl implements MainLeveService {

@Autowired
private RestTemplate restTemplate; ;
    @Override
    public R getAllMainLevel() {
      return  restTemplate.getForObject("http://carserver/carserver/mainlevecontroller/getallmainlevel.do",R.class);
    }

    @Override
    public R addMainLevel(String name) {
        System.out.println(name);
        return restTemplate.postForObject("http://carserver//carserver/mainlevecontroller/addmainlevel.do",name,R.class);
    }

}
