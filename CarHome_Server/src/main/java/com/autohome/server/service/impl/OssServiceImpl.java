package com.autohome.server.service.impl;

import com.autohome.common.baidu.CensorUtil;
import com.autohome.common.baidu.OcrUtil;
import com.autohome.common.constant.SystemConstant;
import com.autohome.common.oss.OssCore;
import com.autohome.common.util.FileUtil;
import com.autohome.common.util.StringUtil;
import com.autohome.common.vo.R;
import com.autohome.entity.oss.OssOp;
import com.autohome.server.dao.OssOpDao;
import com.autohome.server.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: OpenMain
 * @description:
 * @author: Jerry(姜源)
 * @create: 2020-07-17 12:12
 */
@Service
public class OssServiceImpl implements OssService {
    @Autowired
    private OssOpDao opDao;

    @Override
    public R upload(MultipartFile file) {
        // 非空校验
        if (!file.isEmpty()) {
            try {
                // 获取上传的内容
                byte[] data = file.getBytes();
                // 图片内容审核
                if (CensorUtil.checkImg(data)) {
                    // 文件重命名、限制长度
                    String fn = FileUtil.rename(file.getOriginalFilename());
                    // OSS 存储 并返回图片路径
                    String url = OssCore.sendResouce(SystemConstant.OSS_BUCKET, fn, file.getBytes());
                    if (StringUtil.isnoEmpty(url)) {
                        // url存入数据库
                        opDao.save(new OssOp(fn, SystemConstant.OSSTYPE_IMG));
                        return R.ok(url);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return R.fail("oss上传失败，请检查上传的内容");
    }

    @Override
    public R uploadIdcard(MultipartFile file) {
        return uploadAndOcr(1, file);
    }

    @Override
    public R uploadBusine(MultipartFile file) {
        return uploadAndOcr(2, file);
    }

    private R uploadAndOcr(int type, MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // 获取上传的内容
                byte[] data = file.getBytes();
                // 进行图片内容审核
                if (CensorUtil.checkImg(data)) {
                    String no = null;
                    switch (type) {
                        case 1:
                            //身份证
                            no = OcrUtil.idcard(data, true);
                            break;
                        case 2:
                            //营业执照
                            no = OcrUtil.busine(data);
                            break;
                        default:
                            break;
                    }

                    //校验识别
                    if (StringUtil.isnoEmpty(no)) {
                        // 文件重命名、限制长度
                        String fn = FileUtil.rename(file.getOriginalFilename());
                        // OSS 存储 并返回图片路径
                        String url = OssCore.sendResouce(SystemConstant.OSS_BUCKET, fn, file.getBytes());
                        if (StringUtil.isnoEmpty(url)) {
                            //记录数据库
                            opDao.save(new OssOp(fn, SystemConstant.OSSTYPE_IMG));
                            return R.ok(url);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return R.fail("证件上传失败，请检查证件的内容");
    }

    @Override
    public R all() {
        return R.ok(opDao.selectAll());
    }
}
