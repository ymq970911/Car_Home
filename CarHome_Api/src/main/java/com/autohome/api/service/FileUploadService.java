package com.autohome.api.service;

import com.autohome.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Interface: FileUploadService
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/11 20:48
 */
@FeignClient("server")
public interface FileUploadService {

    @PostMapping(value = "server/server/file/upload.do", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    R upload(MultipartFile file);

    @PostMapping(value = "server/server/file/uploadid.do", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    R uploadIdcard(MultipartFile file);

    @PostMapping(value = "server/server/file/uploadbus.do", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    R uploadBusine(MultipartFile file);

    @GetMapping(value = "server/server/file/all.do")
    R all();
}
