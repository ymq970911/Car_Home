package com.autohome.common.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.autohome.common.util.DateUtil;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @program: HungryApi
 * @description: 基于阿里云的OSS 实现资源的存储
 * @author: Jerry(姜源)
 * @reference: https://help.aliyun.com/document_detail/32011.html
 */
public class OssCore {
    private static String endpoint = "https://oss-cn-beijing.aliyuncs.com";
    private static String accessKeyId = "xxx";
    private static String accessKeySecret = "yyy";
    private static OSS ossClient;

    /**
     * 创建OSSClient实例。
     */
    static {
        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * 创建存储空间
     * @param bname
     */
    public static void createBucket(String bname) {
        // 创建CreateBucketRequest对象。
        CreateBucketRequest createBucketRequest = new CreateBucketRequest(bname);
        //创建存储空间
        ossClient.createBucket(createBucketRequest);
    }

    /**
     * 列出存储空间
     * @return
     */
    public static List<Bucket> listBucket() {
        return ossClient.listBuckets();
    }

    /**
     * 上传 --字符串
     * @param bname BUCKET名称
     * @param objname
     * @param msg
     * @return
     */
    public static String sendStr(String bname, String objname, String msg) {
        //实现上传
        ossClient.putObject(bname, objname, new ByteArrayInputStream(msg.getBytes()));
        //获取访问路径
        return ossClient.generatePresignedUrl(bname, objname, DateUtil.comDate(Calendar.YEAR, 1)).toString();
    }

    //上传 --字节
    public static String sendResouce(String bname, String objname, byte[] data) {
        ossClient.putObject(bname, objname, new ByteArrayInputStream(data));
        //获取访问路径
        return ossClient.generatePresignedUrl(bname, objname, DateUtil.comDate(Calendar.YEAR, 1)).toString();
    }

    //上传 --文件
    public static String sendResouce(String bname, File file) {
        ossClient.putObject(bname, file.getName(), file);
        //获取访问路径
        return ossClient.generatePresignedUrl(bname, file.getName(), DateUtil.comDate(Calendar.YEAR, 1)).toString();
    }

    public static String createURL(String bname, String objname, int days) {
        //获取访问路径
        return ossClient.generatePresignedUrl(bname, objname, DateUtil.comDate(Calendar.DAY_OF_MONTH, days)).toString();
    }

    //删除
    public static boolean delResource(String bname, String objname) {
        try {
            ossClient.deleteObject(bname, objname);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //列举文件
    public static List<String> listResource(String bname) {
        List<String> files = new ArrayList<>();
        ObjectListing listing = ossClient.listObjects(bname);
        for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
            files.add(objectSummary.getKey());
        }
        return files;
    }
}
