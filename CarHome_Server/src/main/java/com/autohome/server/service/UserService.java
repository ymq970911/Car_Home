package com.autohome.server.service;

import com.autohome.common.vo.R;

/**
 * @program: OpenMain
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-28 17:32
 */
public interface UserService {
    R<String> checkNickname(String name);
}
