package org.j2os.project.common.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {
    private SHA() {
    }

    public static String get512(String text) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        messageDigest.update(text.getBytes());
        byte bytes[] = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            stringBuffer.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return stringBuffer.toString();
    }
}
