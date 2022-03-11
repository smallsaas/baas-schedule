package com.jfeat.module.schedule.oms.tool;

import com.jfeat.crud.core.util.Md5Util;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Md5Helper {
    public static String generateRandomInviteCode() {
        return Md5Util.getRandomSalt(6);
    }

    public static String generateRandomSalt() {
        return Md5Util.getRandomSalt(6);
    }

    public static String encodePassword(String password, String salt) {
        return Md5Util.md5(password, salt);
    }
}
