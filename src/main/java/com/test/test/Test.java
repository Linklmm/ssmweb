package com.test.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;

@Slf4j
public class Test {
    private static final Random RANDOM = new Random();

    public static String buildVerificationKey(Long lessonRecordId, Long lessonId, String passportId) {
        String code = new StringBuilder().append(passportId)
                .append(lessonRecordId)
                .append(lessonId)
                .append(lessonRecordId - lessonId)
                .append("f@T4uGH%^1fN(vR,SCy2^1nM")
                .toString();
        return DigestUtils.sha1Hex(code);
    }

    public static void main(String[] args) {
        //c5d6b14944af8e8d168474a9edc76cceec27cb2e
//        String key = buildVerificationKey(410681L,159721L,"36284714");
//        log.error("===================="+key);
//        random.setSeed(10);

        Integer i = (int) (Math.random() * 4);
        log.error(i + "");

        Runnable r = () -> {
            log.error(RANDOM.nextInt(4) + "");
        };
        for (int j = 0; j < 10; j++) {
            new Thread(r).start();
        }
    }

}
