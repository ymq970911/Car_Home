package com.autohome.common.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.UUID;

/**
 * @program: OpenMain
 * @description:
 * @author: Jerry(姜源)
 * @create: 2020-07-30 16:43
 */
public class JwtUtil {

    /**
     * 以JWT算法生成密文
     *
     * @param msg 需要加密的字符串
     */
    public static String createJWT(String msg) {
        //实例化 建造器对象
        JwtBuilder jwtBuilder = Jwts.builder();
        //设置内容信息
        jwtBuilder.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.setSubject(msg);
        //jwtBuilder.setExpiration() //设置结束时间
        //设置加密的方式
        jwtBuilder.signWith(SignatureAlgorithm.HS256, createKey());
        //生成密文
        return jwtBuilder.compact();
    }

    /**
     * 解析JWT生成的密文
     */
    public static String parseJWT(String msg) {
        return Jwts.parser().setSigningKey(createKey()).parseClaimsJws(msg).getBody().getSubject();
    }

    /**
     * 生成秘钥
     */
    private static SecretKey createKey() {
        String key = "javaopen2001";
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), "AES");
        return secretKey;
    }

    // test
    public static void main(String[] args) {
        String p = "123456";
        String jw = JwtUtil.createJWT(p);
        System.out.println("token 密文：" + jw);
        System.out.println("token 解析：" + JwtUtil.parseJWT(jw));
    }
}
