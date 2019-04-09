package com.test.effectivejava;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-04-01 10:06
 * @Version 1.0
 * @Description 构建equals方法的具体事例
 */
public final class PhoneNumber implements Comparable<PhoneNumber> {
    private final short areaCode, prefix, lineNum;
    private int hashCode;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "areaCode");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "lineNum");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short) val;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber pn = (PhoneNumber) obj;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }


    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Short.hashCode(areaCode);
            result = 31 * result + Short.hashCode(prefix);
            result = 31 * result + Short.hashCode(lineNum);
            hashCode = result;
        }
        return result;
    }

    @Override
    public int compareTo(PhoneNumber o) {
        int result = Short.compare(areaCode, o.areaCode);
        if (result == 0) {
            result = Short.compare(prefix, o.prefix);
            if (result == 0) {
                result = Short.compare(lineNum, o.lineNum);
            }
        }
        return result;
    }

    private static final Comparator<PhoneNumber> COMPARATOR =
            Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
                    .thenComparing(pn -> pn.prefix)
                    .thenComparing(pn -> pn.lineNum);

    public int compareTo2(PhoneNumber pn){
        return COMPARATOR.compare(this,pn);
    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<>();
        PhoneNumber key = new PhoneNumber(707, 867, 5309);
        m.put(key, "Jenny");
        System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
        System.out.println(m.get(key));
        System.out.println(m.equals(new PhoneNumber(707, 867, 5309)));
    }
}
