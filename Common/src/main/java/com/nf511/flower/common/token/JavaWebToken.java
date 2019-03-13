package com.nf511.flower.common.token;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.nf511.flower.common.GsonUtil;
import net.minidev.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import com.google.gson.Gson;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;

public class JavaWebToken {
    /**
     * 1.创建一个32-byte的密匙
     */
    private static final byte[] SECRET_KEY =
            "cas-login@easydatalink@shenzhouyunhe@auth@9999999999999".getBytes();

    /****
     * token创建时间 (避免key被自定义保存数据覆盖)
     */
    private static final String CREATE_TIME_KEY = "__cas_create_time";

    /****
     * token失效时间
     */
    private static final String INVALID_TIME_KEY = "__cas_invalid_time";
    /****
     * 生成token
     *
     * @param payloadMap
     *            用户数据信息
     * @param invalidTime
     *            失效时间
     * @return
     */
    public static String createToken(Map<String, Object> payloadMap, long createTime, long invalidTime) {
        try {
            if (invalidTime < createTime) {
                System.out.println("====> 失效时间必须大于创建时间...");
                return null;
            }
            if (CollectionUtils.isEmpty(payloadMap)) {
                payloadMap = new HashMap<String, Object>();
            }
            payloadMap.put(CREATE_TIME_KEY, System.currentTimeMillis());
            payloadMap.put(INVALID_TIME_KEY, invalidTime);
            System.out.println("====> 生成token用户信息为：" + GsonUtil.GsonString(payloadMap));
            // 3.先建立一个头部Header
            /**
             * JWSHeader参数：1.加密算法法则,2.类型，3.其它 一般只需要传入加密算法法则就可以。 这里则采用HS256
             *
             * Payload 建立一个载荷
             *
             * JWSAlgorithm类里面有所有的加密算法法则，直接调用。
             */
            // 将头部和载荷结合在一起
            JWSObject jwsObject = new JWSObject(new JWSHeader(JWSAlgorithm.HS256),
                    new Payload(new JSONObject(payloadMap)));

            // 建立一个密匙
            JWSSigner jwsSigner = new MACSigner(SECRET_KEY);
            // 签名
            jwsObject.sign(jwsSigner);

            // 生成token
            return jwsObject.serialize();
        } catch (Exception e) {
            System.out.println("====> 创建token失败：" + e);
            e.printStackTrace();
            return null;
        }
    }

    /****
     * 解析出token的Payload部分数据信息
     *
     * @param token
     * @return
     * @since 2018.12.26
     */
    public static Map<String, Object> parsePayloadData(String token) {
        try {
            if (StringUtils.isEmpty(token)) {
                return null;
            }
            // 解析token
            JWSObject jwsObject = JWSObject.parse(token);
            // 获取到载荷
            Payload payload = jwsObject.getPayload();
            // 建立一个解锁密匙
            JWSVerifier jwsVerifier = new MACVerifier(SECRET_KEY);

            Map<String, Object> resultMap = null;
            // 判断token
            if (jwsObject.verify(jwsVerifier)) { // 校验成功（未校验是否过期）
                // 载荷的数据解析成json对象。
                JSONObject jsonObject = payload.toJSONObject();
                Gson gson = new Gson();
                resultMap = gson.fromJson(gson.toJson(jsonObject), Map.class);
            }
            return resultMap;
        } catch (Exception e) {
            System.out.println("====> 解析token失败: " + e);
            e.printStackTrace();
            return null;
        }
    }
    /****
     * 校验token是否过期
     *
     * @param token
     * @return 0-有效 1-失效 2-校验失败
     * @since 2018.12.26
     */
    public static boolean validToken(String token) {
        try {
            if (StringUtils.isEmpty(token)) {
                return false;
            }
            // 解析token
            JWSObject jwsObject = JWSObject.parse(token);

            // 获取到载荷
            Payload payload = jwsObject.getPayload();

            // 建立一个解锁密匙
            JWSVerifier jwsVerifier = new MACVerifier(SECRET_KEY);
            // 判断token
            if (jwsObject.verify(jwsVerifier)) {
                // 载荷的数据解析成json对象。
                JSONObject jsonObject = payload.toJSONObject();
                // 判断token是否过期
                if (jsonObject.containsKey(INVALID_TIME_KEY)) {
                    Long invalidTime = Long.valueOf(jsonObject.get(INVALID_TIME_KEY).toString());
                    Long nowTime = new Date().getTime();
                    System.out.println(" nowTime: " + nowTime + ", invalidTime:" + invalidTime);
                    // 判断是否过期
                    if (invalidTime > nowTime) {
                        System.out.println("token有效");
                        // token有效
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("====> 解析token失败...");
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        Map<String, Object> sessionUser = new HashMap<String, Object>();
        sessionUser.put("loginName", "admin");
        sessionUser.put("email", "pingfan_wzc@163.com");
        sessionUser.put("phone", "15801306497");
        // 单元测试1：success
        long createTime = new Date().getTime();
        long invalidTime = new Date().getTime() + 10 * 60 * 1000;
        String token = createToken(sessionUser, createTime, invalidTime);
        System.out.println("生成token1：" + token);
        // 单元测试2：sessionUser 为null
        String token2 = createToken(null, createTime, invalidTime);
        System.out.println("生成token2: " + token2);

        System.out.println("token1是否有效：" + validToken(token));
        System.out.println("token2是否有效：" + validToken(token2));
        // 解析用户信息
        Map<String, Object> parseUser = parsePayloadData(token);
        System.out.println("====> 解析token1用户信息为：" + new Gson().toJson(parseUser));
        parseUser = parsePayloadData(token2);
        System.out.println("====> 解析token2的用户信息为：" + new Gson().toJson(parseUser));

        // 单元测试3：token失效
        String token3 = createToken(sessionUser, createTime, System.currentTimeMillis());
        System.out.println("生成token3: " + token3);
        System.out.println("token3是否有效：" + validToken(token3));
        System.out.println("解析token3的用户信息为：" + new Gson().toJson(parsePayloadData(token3)));

    }

}
