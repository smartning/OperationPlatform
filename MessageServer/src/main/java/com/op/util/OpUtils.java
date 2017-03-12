package com.op.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import java.security.MessageDigest;
import java.util.List;
import java.util.Objects;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/15.
 ****************************************/
public final class OpUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpUtils.class);
    @Context
    private HttpServletRequest request;
//    private static final Requests requests = new RequestImpl();
    private OpUtils() {
    }

    public final static Boolean checkStringIsNull(String string) {
        if (null == string || string.trim().equals("")) {
            return true;
        }
        return false;
    }

    public final static Boolean checkObjectIsNull(Object obj) {
        try {
            List list = (List) obj;
            if (list.size() <= 0) {
                return true;
            }
        } catch (Exception e) {
            LOGGER.info("check obj is null transfrom list is faile");
        }
        if (Objects.equals(null, obj)) {
            return true;
        }

        return false;
    }

    public final static String getEnvValue(String key) {
        if (!checkStringIsNull(key)) {
            String res = System.getenv(key);
            if (!checkStringIsNull(res)) {
                return res;
            }
            LOGGER.info("env not have '" + key + "' value");
            return null;
        }
        LOGGER.info("get env error, key is null");
        return null;
    }

    public final static Boolean checkMapperCudIsSuccess(int res) {
        return res >= 0 ? true : false;
    }

    public final static String MD5(String pwd) {
        char md5String[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = pwd.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = md5String[byte0 >>> 4 & 0xf];
                str[k++] = md5String[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            LOGGER.error("md5 add secret error");
        }
        return null;
    }

    public static final Boolean checkUserToken(String userId, String accessToken){
//        Params params = new Params("user_id", userId);
//        Params params1 = new Params("access_token", accessToken);
//        List<Params> paramsList = new ArrayList<>();
//        paramsList.add(params);
//        paramsList.add(params1);
//        String json = requests.get("http://localhost:10020/oauth/token/check", null, paramsList).json();
//        LOGGER.info(json);
//        JSONObject object = (JSONObject) JSONObject.parse(json);
//        String success = object.get("success").toString();
//        return success.equals("true");
        return  null;
    }
}
