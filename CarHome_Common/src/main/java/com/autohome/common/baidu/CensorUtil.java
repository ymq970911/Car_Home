package com.autohome.common.baidu;

import com.baidu.aip.contentcensor.AipContentCensor;
import com.baidu.aip.contentcensor.EImgType;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import java.io.*;

/**
 * @program: OpenMain
 * @description: 敏感词/图过滤
 * @author: Jerry(姜源)
 * @create: 2020-07-28 19:52
 */
@Slf4j
public class CensorUtil {
    /**
     * 百度智能云：登陆后 --> 控制台 --> 产品服务 --> 【内容审核】 --> 创建应用 --> 自动生成API KEY
     * AppID / API Key / Secret Key
     * Java SDK 内容审核接口说明：https://cloud.baidu.com/doc/ANTIPORN/s/tk3h6xdji
     */
    public static final String APP_ID = "xxx";
    public static final String API_KEY = "yyy";
    public static final String SECRET_KEY = "zzz";

    /**
     * 创建百度智能云 内容审查对象
     */
    private static AipContentCensor contentCensor;

    static {
        contentCensor = new AipContentCensor(APP_ID, API_KEY, SECRET_KEY);
    }

    /**
     * 敏感文本审核
     *
     * @param msg 需要审核的文本内容
     * @return true 合规，false 不合规
     */
    public static boolean checkText(String msg) {
        if (msg != null && msg.length() > 0) {
            JSONObject response = contentCensor.textCensorUserDefined(msg);
            log.info("文本审核结果：" + response.getString("conclusion"));
            return response.getInt("conclusionType") == 1;
        }
        return true;
    }

    /**
     * 敏感图片审核
     *
     * @param data 图片的内容
     * @return true 合规，false 不合规
     */
    public static boolean checkImg(byte[] data) {
        if (data != null && data.length > 0) {
            JSONObject object = contentCensor.imageCensorUserDefined(data, null);
            log.info("图像审核结果：" + object.getString("conclusion"));
            return object.getInt("conclusionType") == 1;
        } else {
            return true;
        }
    }

    /**
     * 敏感图片审核
     *
     * @param imgUrl 图片的网络地址
     * @return true 合规，false 不合规
     */
    public static boolean checkImg(String imgUrl) {
        if (imgUrl != null && imgUrl.length() > 0) {
            JSONObject object = contentCensor.imageCensorUserDefined(imgUrl, EImgType.URL, null);
            log.info("图像审核结果：" + object.getString("conclusion"));
            return object.getInt("conclusionType") == 1;
        } else {
            return true;
        }
    }

    /**
     * 测试
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String str = "免费翻墙";
        System.out.println(str + " ---> " + checkText(str));

        String imgName = "E:\\图片\\test\\xjp.jpg";
        FileInputStream fis = new FileInputStream(new File(imgName));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] arr = new byte[1024];
        int len;
        while ((len = fis.read(arr)) != -1) {
            baos.write(arr, 0, len);
        }
        System.out.println(imgName + " ---> " + checkImg(baos.toByteArray()));

        String imgUrl = "https://img-blog.csdnimg.cn/xxx.png";
        System.out.println(imgUrl + " ---> " + checkImg(imgUrl));
    }
}
