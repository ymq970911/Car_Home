package com.autohome.server.dao;

import com.autohome.entity.oss.OssOp;

import java.util.List;

/**
 * @program: OpenMain
 * @description:
 * @author: Jerry(姜源)
 * @create: 2020-07-29 12:09
 */
public interface OssOpDao {
    int save(OssOp ossOp);

    List<OssOp> selectAll();
}
