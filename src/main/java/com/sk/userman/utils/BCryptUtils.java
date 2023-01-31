package com.sk.userman.utils;

import java.util.regex.Pattern;

public class BCryptUtils {

    private static Pattern BCRYPT_PATTERN = Pattern
            .compile("\\A\\$2(a|y|b)?\\$(\\d\\d)\\$[./0-9A-Za-z]{53}");
    /**
     * 生成BCryptPasswordEncoder密码
     * @param rawPassword 密码
     * @return 加密字符串
     */
    public static String encode(CharSequence rawPassword) {
        String salt;
        salt = BCrypt.gensalt();
        return BCrypt.hashpw(rawPassword.toString(), salt);
    }


    /**
     * 判断密码是否相同
     * @param rawPassword 真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (encodedPassword == null || encodedPassword.length() == 0) {
            return false;
        }
        if (!BCRYPT_PATTERN.matcher(encodedPassword).matches()) {
            return false;
        }
        return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
    }
}
