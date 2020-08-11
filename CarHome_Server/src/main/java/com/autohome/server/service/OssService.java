package com.autohome.server.service;

import com.autohome.common.vo.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: OpenMain
 * @description:
 * @author: Jerry(姜源)
 * @create: 2020-07-29 12:00
 */
public interface OssService {
    R upload(MultipartFile file);

    R uploadIdcard(MultipartFile file);

    R uploadBusine(MultipartFile file);

    R all();
}
