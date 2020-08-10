package com.autohome.server.service.impl;




import com.autohome.common.dto.BrandLevDto;
import com.autohome.common.vo.R;
import com.autohome.entity.MainLevel;
import com.autohome.server.dao.BrandLevelDao;
import com.autohome.server.dao.MainLevelDao;
import com.autohome.server.service.BrandLeveService;
import com.autohome.server.service.MainLeveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YMQ
 */
@Service
public class MainLeveServiceImpl implements MainLeveService {

@Autowired
private MainLevelDao dao;
    @Override
    public R getAllMainLevel() {
        List<MainLevel> allMainLevel = dao.getAllMainLevel();
        if (allMainLevel!=null && allMainLevel.size()>0){
            return R.ok(allMainLevel);
        }
        else {
            return R.fail("未查询到结果");
        }
    }

    @Override
    public R addMainLevel(String name) {
        System.out.println(name);
        int i = dao.addMainLevel(name);

        if (i>0){
            return R.ok();
        }else {
            return R.fail("添加失败");
        }
    }

}
