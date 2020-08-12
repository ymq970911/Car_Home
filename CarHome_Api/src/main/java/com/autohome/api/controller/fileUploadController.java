package com.autohome.api.controller;

import com.autohome.api.service.FileUploadService;
import com.autohome.common.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Class: fileUploadController
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/08/11 20:04
 */
@Api(tags = "文件上传接口")
@RestController
@RequestMapping("/api/file")
public class fileUploadController {

    @Autowired
    private FileUploadService service;

    /**
     * 普通文件上传
     *
     * @param file
     * @return
     */
    @PostMapping("/upload.do")
    public R upload(MultipartFile file) {
        return service.upload(file);
    }

    /**
     * 上传身份证
     *
     * @param file
     * @return
     */
    @PostMapping("/uploadid.do")
    public R uploadId(MultipartFile file) {
        return service.uploadIdcard(file);
    }

    /**
     * 上传营业执照
     *
     * @param file
     * @return
     */
    @PostMapping("/uploadbus.do")
    public R uploadBus(MultipartFile file) {
        return service.uploadBusine(file);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("/all.do")
    public R all() {
        return service.all();
    }

}
