package com.zhihao.synthapixclientsdk.Utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

import java.time.Instant;

/**
 * @author Zhihao Zhang
 * @description TODO
 * @date 2024-04-15 12:15 AM
 */
public class SignUtils {
    public static String genSign(String body, String secretKey){
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String content = body + secretKey;
        String digestHex = md5.digestHex(content);
        return digestHex;
    }

    public static boolean isTimestampValid(String clientTimestamp) {
        long timestamp;
        try {
            timestamp = Long.parseLong(clientTimestamp);
        } catch (NumberFormatException e) {
            return false;
        }
        long currentSeconds = Instant.now().getEpochSecond();
        long difference = Math.abs(currentSeconds - timestamp); // Absolute difference in seconds

        return difference <= 300; // 300 seconds = 5 minutes
    }
}
