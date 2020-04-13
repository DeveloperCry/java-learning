package com.learning.demo.utils;

import com.learning.demo.constants.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import java.io.UnsupportedEncodingException;

@Slf4j
public class Base64Util {
    /**
     * 解密
     * @param data
     * @return
     */
    public static String decode(String data) {
        if (StringUtils.isNotBlank(data)) {
            try {
                return new String(Base64.decodeBase64(data.getBytes(Constant.CHARSET_UTF_8)), Constant.CHARSET_UTF_8);
            } catch (UnsupportedEncodingException e) {
                log.error(String.format("字符串：%s，解密异常", data), e);
            }
        }

        return null;
    }

    /**
     * 加密
     * @param data
     * @return
     */
    public static String encode(String data) {
        if (StringUtils.isNotBlank(data)) {
            try {
                return new String(Base64.encodeBase64(data.getBytes(Constant.CHARSET_UTF_8)), Constant.CHARSET_UTF_8);
            } catch (UnsupportedEncodingException e) {
                log.error(String.format("字符串：%s，加密异常", data), e);
            }
        }
        return null;
    }
}
